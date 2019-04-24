package common;

/**
 * Scope.
 *
 * @author Ilya_Gulevskiy
 */
public class Scope {

    private ScopeStaticI ss;

    public static void go() {
        ScopeStaticI ss = new ScopeStaticImpl();
        ScopeStaticI.staticMethod();
        ss.defaultMethod();

        // Не могу вызвать статику через имплементацию
//        ScopeStaticImpl.staticMethod();
//        ss.staticMethod();

        System.out.println();
    }
}

interface ScopeStaticI {
    // Field in interface is final static
    int field = 2;

    static void staticMethod() {
        System.out.println("ScopeStaticI staticMethod");
    }

    default void defaultMethod()  {
        System.out.println("ScopeStaticI.defaultMethod");
    }
}

class ScopeStaticImpl implements  ScopeStaticI {
    // если реализовать свой staticMethod, то он будет доступен через эту имплементацию


}


