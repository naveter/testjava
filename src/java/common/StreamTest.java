package common;

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

    public static void go() {
        StreamTest st = new StreamTest();
        st.terminateOperation();

        System.out.println(split("Hello, fro, usa, today"));

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

    public static List<String> split(String str){
        return Arrays.asList(str.split(","));
    }



}
