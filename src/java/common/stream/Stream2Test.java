package common.stream;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;

public class Stream2Test {

    public static void go() {
        Stream2Test test = new Stream2Test();
        test.create();
        test.intermediate();
        test.terminal();

    }

    private void create() {
        Stream.Builder<Integer> numBuilder = Stream.builder();
        numBuilder.add(1).add(2).add( 3);
        Stream<Integer> numStream = numBuilder.build();
        System.out.println(numStream.collect(Collectors.toList()));

        Stream<Integer> numStream2 = Stream.of(1, 2, 3);
        Integer[] arr = {1, 2, 3, 4, 5};
        Stream<Integer> numStream3 = Arrays.stream(arr);
        System.out.println(Stream.concat(numStream2, numStream3).collect(Collectors.toList()));

    }

    // Промежуточные операции
    // filter(), map(), different(), peek(), sorted()
    private void intermediate() {
        Stream<Integer> numStream = Stream.of(43, 65, 1, 98, 63);
        List<Integer> even = numStream.filter(n -> n % 2 == 0) .collect(Collectors.toList());
        System.out.println("filter(): " + even);

        Stream<Integer> numStream2 = Stream.of(43, 65, 1, 98, 63);
        List<Integer> d = numStream2.map(n -> n*2) .collect(Collectors.toList());
        System.out.println("map(): " + d);

        Stream<Integer> numStream3 = Stream.of(43,65,1,98,63,63,1);
        List<Integer> numList = numStream3.distinct() .collect(Collectors.toList());
        System.out.println("distinct(): " + numList);

        Stream<Integer> numStream4 = Stream.of(43, 65, 1, 98, 63);
        List<Integer> nList = numStream4.map(n -> n*10)
                .peek(n -> System.out.println("Mapped: "+ n))
                .collect(Collectors.toList());
        System.out.println("map() + peek(): " + nList);

        Stream<Integer> numStream5 = Stream.of(43, 65, 1, 98, 63);
        System.out.print("sorted(): ");
        numStream5.sorted().forEach(n -> System.out.print(n + " "));
        System.out.println("");


    }

    // Терминальные операции
    // forEach(), collect(), count(), reduce()
    private void terminal() {
        Stream<Integer> numStream = Stream.of(43, 65, 1, 98, 63);
        System.out.print("forEach(): ");
        numStream.forEach(n -> System.out.print(n + " "));
        System.out.println("");

        Stream<Integer> numStream2 = Stream.of(43, 65, 1, 98, 63);
        System.out.println("count(): " + numStream2.count());

        Stream<Integer> numStream3 = Stream.of(43, 65, 1, 98, 63);
        List<Integer> odd = numStream3.filter(n -> n % 2 == 1) .collect(Collectors.toList());
        System.out.println("filter() + collect(): " + odd);

        Stream<Integer> numStream4 = Stream.of(43, 65, 1, 98, 63);
        int smallest = numStream4.min((m, n) -> Integer.compare(m, n)).get();
        System.out.println("Smallest element: " + smallest);

        Stream<Integer> numStream5 = Stream.of(43, 65, 1, 98, 63);
        Optional<Integer> opt = numStream5.findFirst();
        System.out.println(opt);
        numStream = Stream.empty();
        opt = numStream.findAny();
        System.out.println(opt);

        Stream<Integer> numStream6 = Stream.of(43, 65, 1, 98, 63);
        boolean flag = numStream6.allMatch(n -> n > 0);
        System.out.println("allMatch(): " + flag);
        numStream = Stream.of(43, 65, 1, 98, 63);
        flag = numStream.anyMatch(n -> n > 63);
        System.out.println("anyMatch(): " + flag);
        numStream = Stream.of(43, 65, 1, 98, 63);
        flag = numStream.noneMatch(n -> n == 1);
        System.out.println("noneMatch(): " + flag);

    }
}
