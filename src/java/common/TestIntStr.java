package common;

import java.util.ArrayList;
import java.util.List;

public class TestIntStr {

    public static void go() {
        System.out.println("(Integer) 1 == (Integer) 1:" + ((Integer) 1 == (Integer) 1));
        System.out.println("(Integer) 129 == (Integer) 129:" + ((Integer) 129 == (Integer) 129));


        String s3 = new String("a");
        String s4 = new String("a");
        System.out.println("new String('a') == new String('a'):" + (s3 == s4));
        System.out.println("new String('a').intern() == new String('a').intern():" + (s3.intern() == s4.intern()));


        String s1 = "b";
        String s2 = "b";
        System.out.println("String 'a' == 'a': " + (s1 == s2));

        // При добавлении в список используется конрвариантность super
        List<? super Number> numList = new ArrayList<>();
        numList.add(new Integer(10));

        // Case with explanation especial state of String as return value from method
        String someString = "_someString";
        String someString2 = "_someString";
        System.out.println("someString == '_' + getString():" + (someString == "_" + getString()));
        System.out.println("someString.equals('_' + getString()):" + someString.equals("_" + getString()));
        System.out.println("someString == somestring2:" + (someString == someString2));
    }

    private static String getString() {
        return "someString";
    }
}
