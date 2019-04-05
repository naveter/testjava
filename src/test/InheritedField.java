package test;


public class InheritedField {
    class A {
        String str = "ab";

        A() {
            printLength();
        }

        void printLength() {
            System.out.println(str.length());
        }
    }

    class B extends A {
        String str = "abc";

        void printLength() {
            // NullPointerException - str вызывается в конструкторе предка и пока не определилось в наследнике
//            System.out.println(str.length());
        }
    }

    // Попытка множественного наследования
    class ExtOuterClass extends OuterClass {
        @Override
        public void outerMethod() {
            super.outerMethod();
        }
        // Тут возвращаемое значение изменено на потомка
        @Override
        public Child sig(Parent p) {
            return (Child) super.sig(p);
        }
    }

    public static void main() {
        new InheritedField().new ExtOuterClass().outerMethod();
        new InheritedField().new B();
    }

}

class OuterClass {
    void outerMethod() {
        System.out.println("From OuterClass.outerMethod()");
    }
    Parent sig(Parent p){
        return p;
    }
}

class Parent {

}
class Child extends Parent {

}
class SubChild extends Child {

}

