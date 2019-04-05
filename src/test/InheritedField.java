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
            System.out.println(str.length());
        }
    }

    // Попытка множественного наследования
    class ExtOuterClass extends test.sub.OuterClass {
        @Override
        public void outerMethod() {
            super.outerMethod();
        }
        // Тут возвращаемое значение изменено на потомка
        @Override
        public test.sub.Child sig(test.sub.Parent p) {
            return (test.sub.Child) super.sig(p);
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
    test.sub.Parent sig(test.sub.Parent p){
        return p;
    }
}

class Parent {

}
class Child extends test.sub.Parent {

}
class SubChild extends test.sub.Child {

}

