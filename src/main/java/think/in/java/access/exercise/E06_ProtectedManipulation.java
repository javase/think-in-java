package think.in.java.access.exercise;

/**
 * Created by limenghua on 2017/6/6.
 */
class WithProtected {
    protected int i;
}

public class E06_ProtectedManipulation {
    public static void main(String args[]) {
        WithProtected wp = new WithProtected();
        wp.i = 47;
        System.out.println("wp.i = " + wp.i);
    }
} /* Output:
wp.i = 47
*///:~
