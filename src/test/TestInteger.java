package test;

import java.util.ArrayList;
import java.util.List;

public class TestInteger {

    public static void go() {
        System.out.println("(Integer) 1 == (Integer) 1:" + ((Integer) 1 == (Integer) 1));
        System.out.println("(Integer) 129 == (Integer) 129:" + ((Integer) 129 == (Integer) 129));


        String s3 = new String("a");
        String s4 = new String("a");
        System.out.println("new String('a') == new String('a'):" + (s3 == s4));


        String s1 = "b";
        String s2 = "b";
        System.out.println("String 'a' == 'a': " + (s1 == s2));

        List<? extends Number> numList = new ArrayList<>();
//        numList.add(new Integer(10));

    }
}
