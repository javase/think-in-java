package think.in.java.access.exercise.local;

/**
 * Created by limenghua on 2017/6/6.
 */
public class E05_Other {
    public E05_Other() {
        E05_AccessControl test = new E05_AccessControl();
        test.a = 1;
        //! test.b = 2; // Can't access:  private
        test.c = 3;
        test.d = 4;
        test.f1();
        //! test.f2(); // Can't access:  private
        test.f3();
        test.f4();
    }
} ///:~
