package bookslib;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Bookslib {

    private static Library library = new Library();

    public static void main(String args[]) {
        compare();
        sendingList();
        createSendList();
        allBookedBooks();
        orwell();
        maxBookedBooks();
        sendTo2Groups();
        getListOfGroups();
        getListOfGroupsFormat();
    }

    /**
     * Отсортировать все книги
     */
    public static void compare() {
        List list = library.getBooks().stream()
                .sorted(Comparator.comparing(Book::getIssueYear))
                .collect(Collectors.toList());

        System.out.println(list);
    }

    /**
     * Требуется создать список рассылки (объекты типа EmailAddress) из адресов всех читателей библиотеки.
     */
    public static void sendingList() {
        List<EmailAddress> addresses = library.getReaders().stream()
                .map(Reader::getEmail)
                .map(EmailAddress::new)
                .collect(Collectors.toList());

        System.out.println(addresses);
    }

    /**
     * Снова нужно получить список рассылки. Но на этот раз включаем в него только адреса читателей,
     * которые согласились на рассылку. Дополнительно нужно проверить, что читатель взял из библиотеки больше одной книги.
     */
    public static void createSendList() {
        List<EmailAddress> addresses = library.getReaders().stream()
                .filter(Reader::isSubscriber)
                .filter(reader -> reader.getBooks().size() > 1)
                .map(Reader::getEmail).map(EmailAddress::new)
                .collect(Collectors.toList());

        System.out.println(addresses);
    }

    /**
     * Получить список всех книг, взятых читателями. Список не должен содержать дубликатов
     * (книг одного автора, с одинаковым названием и годом издания).
     */
    public static void allBookedBooks() {
        List<Book> bookList = library.getReaders().stream()
                .flatMap(reader -> reader.getBooks().stream())
                .distinct()
                .collect(Collectors.toList());

        System.out.println(bookList);
    }

    /**
     * Проверить, взял ли кто-то из читателей библиотеки какие-нибудь книги Оруэлла.
     */
    public static void orwell() {
        boolean match = library.getReaders().stream()
                .flatMap(reader -> reader.getBooks().stream())
                .anyMatch(book -> "Оруэлл".equals(book.getAuthor()));

        System.out.println(match);
    }

    /**
     * Узнать наибольшее число книг, которое сейчас на руках у читателя.
     */
    public static void maxBookedBooks() {
        Integer reduce = library.getReaders().stream()
                .map(reader -> reader.getBooks().size())
                .reduce(0, (max, size) -> size > max ? size : max);

        System.out.println(reduce);
    }

    /**
     * Send letters for two groups: whom has more than 2 books and whom less
     */
    public static void sendTo2Groups() {
        Map<String, List<EmailAddress>> map = library.getReaders().stream()
                .filter(Reader::isSubscriber)
                .collect(groupingBy(r -> r.getBooks().size() >= 2 ? "TOO_MUCH" : "OK",
                        mapping(r -> new EmailAddress(r.getEmail()), Collectors.toList())));

        System.out.println(map);
    }

    /**
     * Get list of readers in each group
     */
    public static void getListOfGroups() {
        Map<String, List<Reader>> readerstMap = library.getReaders().stream()
                .filter(Reader::isSubscriber)
                .collect(groupingBy(r -> r.getBooks().size() > 2 ? "TOO_MUCH" : "OK"));

        System.out.println(readerstMap);
    }

    /**
     * Если для каждой группы нужны ФИО читателей из этой группы, перечисленные через запятую.
     * И ещё каждый такой список ФИО нужно обернуть фигурными скобками.
     */
    public static void getListOfGroupsFormat() {
        Map<String, String> readersFIOMap = library.getReaders().stream()
                .filter(Reader::isSubscriber)
                .collect(groupingBy(r -> r.getBooks().size() > 2 ? "TOO_MUCH" : "OK",
                        mapping(Reader::getFio, joining(", ", "{", "}"))));

        System.out.println(readersFIOMap);
    }



}
