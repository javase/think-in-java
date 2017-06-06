package think.in.java.access.exercise.local;

/**
 * Created by limenghua on 2017/6/6.
 */
public class E05_AccessControl {
    public int a;
    private int b;
    protected int c;
    int d; // Package access

    public void f1() {
    }

    private void f2() {
    }

    protected void f3() {
    }

    void f4() {
    } // Package access

    public static void main(String args[]) {
        E05_AccessControl test = new E05_AccessControl();
        // No problem accessing everything inside
        // of main() for this class, since main()
        // is a member and therefore has access:
        test.a = 1;
        test.b = 2;
        test.c = 3;
        test.d = 4;
        test.f1();
        test.f2();
        test.f3();
        test.f4();
    }
}  ///:~
