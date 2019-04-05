package test.sub;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TestGenerics.
 *
 * @author Ilya_Gulevskiy
 */
public class TestGenerics {
    public static void go() {
        Child ch1 = new Child();

        Type st1 = ch1.covGen(new SubType());
        Type st2 = ch1.covGen(new SubSubType());

        List<SubSubType> list0 = Arrays.asList(new SubSubType(), new SubSubType());
        List<SubType> list1 = ch1.covList(list0);

        List<SubSubType> list2 = Arrays.asList(new SubSubType(), new SubSubType()).stream().collect(Collectors.toList());
        List<SubType> r1 = ch1.readFromCovar(list2);
        ch1.readFromCoverGen(list2);

        List<? super SubType> contrList = new ArrayList<>();
        contrList.add(new SubType());
        contrList.add(new SubSubType());
        ch1.write2contr(contrList);

        List<Type> contrList2 = new ArrayList<>();
        contrList2.add(new SubType());
        contrList2.add(new SubSubType());
        ch1.write2contr(contrList2);

        List<Type> contrList3 = Arrays.asList(new SubType(), new SubSubType()).stream().collect(Collectors.toList());
        List<? super SubType> contrList4 = ch1.write2contr(contrList3);
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
    <T extends Type> T covGen(T p){
        return p;
    }
    List<SubType> covList(List<? extends SubType> list) {
        return (List<SubType>)list;
    }
    // ковариантный список для чтения
    List<SubType> readFromCovar(List<? extends SubType> list) {
        // Я знаю, что тип не менее SubType, могу читать
        SubType s = list.get(0);

        // Но для записи я должен создать новый список с кастом к SubType
        List<SubType> st = (List<SubType>) list;
        st.add(new SubType());

        return st;
    }
    // то-же самое с дженериком
    <T extends SubType> List<T> readFromCoverGen(List<T> list) {
        SubType s = list.get(0);
        return list;
    }

    // контрвариантный список для изменения
    List<? super SubType> write2contr(List<? super SubType> list) {
        list.add(new SubType());
        return list;
    }
    // то-же самое, но с дженериком не работает
//    <K super SubType> List<K> write2contrGen(List<K> list) {
//        list.add(new SubType());
//        return list;
//    }


}




// types
class Type {

}
class SubType extends Type {

}
class SubSubType extends SubType {

}