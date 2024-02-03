package common;

import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * StreamTest.
 *
 * @author Ilya_Gulevskiy
 */
public class StreamTest {

    public static void main(String[] args) {
        sumOfObject();

    }

    public static void go() {
        StreamTest st = new StreamTest();
        st.terminateOperation();
        st.funcInterfaces();
        st.sumOfObject();

    }

    public int counter = 0;

    public void terminateOperation() {
        List<String> list = Arrays.asList("abc1", "abc2", "abc3");

        // without collector filter() will ask never
        Stream<String> stream = list.stream().filter(element -> {
            counter++;
            return element.contains("2");
        });
        System.out.println(counter);
    }

    public void funcInterfaces() {
        // Predicate
        List<Integer> evenNumbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8)
                .filter(x -> x % 2==0)
                .collect(Collectors.toList());
        System.out.println(counter);

        // Consumer
        List<String> peopleGreetings = Stream.of("Elena", "John", "Alex", "Jim", "Sara")
                .peek(x -> System.out.println("Hello " + x + " !!!"))
                .collect(Collectors.toList());

        // Supplier
        List<String> nameList = Arrays.asList("abc1", "abc2", "abc3");
        Stream.generate(() -> {
            int value = (int) (Math.random() * nameList.size());
            return nameList.get(value);
        }).limit(5).forEach(System.out::println);

        // Function
        List<Integer> values = Stream.of("32", "43", "74", "54", "3")
                .map(x -> Integer.valueOf(x)).collect(Collectors.toList());
        System.out.println(values);

        // UnaryOperator
        Stream.iterate(9, x -> x * x)
                .limit(4)
                .forEach(System.out::println);



    }

    @RequiredArgsConstructor
    public static class Order {
        String title;
        List<Object> items;
        Double sum;

        public Order(String title, List<Object> items, Double sum) {
            this.title = title;
            this.items = items;
            this.sum = sum;
        }

        public Double getSum() {
            return this.sum;
        }
    }

    static Double summAll1 = 0D;

    /**
     * Calculate with StreamAPI amount of field sum
     */
    public static void sumOfObject() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("Samanta", null, 25D));
        orders.add(new Order("Smith", null, 30D));
        System.out.println(
                orders.stream().mapToDouble(Order::getSum).sum()
        );
        System.out.println(
                orders.stream().collect(Collectors.summingDouble(o -> o.getSum()))
        );

        orders.stream().forEach( i -> summAll1 += i.getSum());
        System.out.println(summAll1);



    }





}
