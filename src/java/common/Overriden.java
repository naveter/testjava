package common;

public class Overriden {
    public Object testOverride() {
        return new Object();
    }

    public static void main(String[] args) {
        OverrideChild och = new OverrideChild();
        System.out.println(och.testOverride().toString());
    }
}

class OverrideChild extends Overriden {
    @Override
    public Integer testOverride() {
        return new Integer(2);
    }
}