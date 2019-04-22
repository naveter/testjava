package test;

/**
 * Scope.
 *
 * @author Ilya_Gulevskiy
 */
public class Scope {

    public static void go() {
        ScopeStaticI ss = new ScopeStaticImpl();
        ScopeStaticI.staticMethod();
        ss.defaultMethod();

        // Не могу вызвать статику через имплементацию
//        ScopeStaticImpl.staticMethod();
//        ss.staticMethod();

    }
}

interface ScopeStaticI {
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


