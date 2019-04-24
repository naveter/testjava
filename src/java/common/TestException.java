package common;

public class TestException {
    public static String method() {

        if(System.out.printf("Hello world") == null){}

        System.out.println("MAX_VALUE: " + (Double.MAX_VALUE + Math.pow(2, 969) == Double.MAX_VALUE)
                + ", " + (Double.MAX_VALUE + Math.pow(2, 970) == Double.POSITIVE_INFINITY)); // true

        try {
//            System.exit(0);
            return "SomeString";
        } finally {
            return "Finally message";
        }
    }
}
