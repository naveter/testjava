package test;


public class InheritedField {
    private String privateField = "Iam private field";

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

        @Override
        void printLength() {
            // NullPointerException - str вызывается в конструкторе предка и пока не определилось в наследнике
//            System.out.println(str.length());
        }
    }

    // Попытка множественного наследования
    class ExtOuterClass extends OuterClass {

        // Внутренний класс не может иметь статических полей
        public /*static*/ void ss() {

        }

        @Override
        public void outerMethod() {
            // Доступ к private-полю внешнего класса
            System.out.println(InheritedField.this.privateField);
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

