package common.otherpackage;

/**
 * Child.
 *
 * @author naveter
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
