package bookslib;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books;
    private List<Reader> readers;

    public Library() {
        init();
    }

    private void init() {
        books = new ArrayList<>();
        books.add(new Book("Оруэлл", "1984", 2021));
        books.add(new Book("Чехов", "Камчатка", 2015));
        books.add(new Book("Толкиен", "Хоббит", 2005));
        books.add(new Book("Гоголь", "Петербуржские рассказы", 2014));
        books.add(new Book("Чехов", "Рассказы", 2015));
        books.add(new Book("Толкиен", "Властелин колец", 2005));
        books.add(new Book("Гоголь", "Мёртвые души", 2014));
        books.add(new Book("Тургенев", "Записки охотника", 2010));

        readers = new ArrayList<>();
        readers.add(new Reader("Иванов Иван Иванович", "ivanov.email@test.ru", true));
        readers.get(0).getBooks().add(books.get(0));
        readers.get(0).getBooks().add(books.get(1));

        readers.add(new Reader("Настасья Филлиповна", "phillipovna23@test.ru", false));
        readers.get(1).getBooks().add(books.get(2));
        readers.get(1).getBooks().add(books.get(3));

        readers.add(new Reader("Барменталь", "barmental@test.ru", true));
        readers.get(2).getBooks().add(books.get(4));
        readers.get(2).getBooks().add(books.get(5));
        readers.get(2).getBooks().add(books.get(6));

        readers.add(new Reader("Шапошников", "shapka@test.ru", true));
        readers.get(3).getBooks().add(books.get(7));

    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Reader> getReaders() {
        return readers;
    }
}
