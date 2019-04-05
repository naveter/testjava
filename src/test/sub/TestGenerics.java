package test.sub;

import java.util.Arrays;
import java.util.List;

/**
 * TestGenerics.
 *
 * @author Ilya_Gulevskiy
 */
public class TestGenerics {
    public static void go() {
        Child ch1 = new Child();

        // примеры работы с ковариантным дженериком
        Type st1 = ch1.covGen(new SubType());
        Type st2 = ch1.covGen(new SubSubType());

        List<SubSubType> list0 = Arrays.asList(new SubSubType(), new SubSubType());
        List<SubType> list1 = ch1.covList(list0);
    }
}



class Child extends Parent {
    // Могу вовращать субтип и изменить видимость
    @Override
    public SubType sig(Type t) {
        return (SubType) super.sig(t);
    }
}

class Parent {
    Type sig(Type t) {
        return t;
    }

    // ковариантность
    <T extends Type> T covGen(T p){
        return p;
    }
    List<SubType> covList(List<? extends SubType> list) {
        return (List<SubType>)list;
    }
}




// types
class Type {

}
class SubType extends Type {

}
class SubSubType extends SubType {

}