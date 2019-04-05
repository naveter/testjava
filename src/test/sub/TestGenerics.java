/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2019 VTB Group. All rights reserved.
 */

package test.sub;

/**
 * TestGenerics.
 *
 * @author Ilya_Gulevskiy
 */
public class TestGenerics {
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