package common.otherpackage;

/**
 * Child.
 *
 * @author Ilya_Gulevskiy
 */
public class Child extends Parent {
    // Изменили видимость метода
    @Override
    public void sig(String s) {
    }

    @Override
    public String ret() {
        return "str";
    }
}
