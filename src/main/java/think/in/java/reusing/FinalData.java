package think.in.java.reusing;//: reusing/FinalData.java
// The effect of final on fields.

import java.util.*;

import static net.mindview.util.Print.*;

class Value {
    int i; // Package access

    public Value(int i) {
        this.i = i;
    }
}

/**
 * final关键字探究
 */
public class FinalData {
    private static Random rand = new Random(47);
    private String id;

    public FinalData(String id) {
        this.id = id;
    }

    // Can be compile-time constants:
    private final int valueOne = 9;
    private static final int VALUE_TWO = 99;
    // Typical public constant:
    public static final int VALUE_THREE = 39;
    // Cannot be compile-time constants:
    // INT_5只有一份，new多个FinalData对象，这个变量只有一份
    private final int i4 = rand.nextInt(20);
    static final int INT_5 = rand.nextInt(20);
    private Value v1 = new Value(11);
    // 引用类型指定为final
    // final意味着无法将v2再次指向另一个新的对象
    private final Value v2 = new Value(22);
    private static final Value VAL_3 = new Value(33);
    // Arrays:
    private final int[] a = {1, 2, 3, 4, 5, 6};

    @Override
	public String toString() {
        return id + ": " + "i4 = " + i4 + ", INT_5 = " + INT_5;
    }

    public static void main(String[] args) {
        FinalData fd1 = new FinalData("fd1");
        //! fd1.valueOne++; // Error: can't change value
        print("fd1.v2.i:" + fd1.v2.i);
        fd1.v2.i++; // Object isn't constant!

        // final意味着无法将v2再次指向另一个新的对象
        // 以下指定会报错  cannot assign a value to final variable 'v2'
        // fd1.v2 = new Value(23);


        print("fd1.v2.i++:" + fd1.v2.i);
        fd1.v1 = new Value(9); // OK -- not final
        for (int i = 0; i < fd1.a.length; i++) {
            fd1.a[i]++;
        } // Object isn't constant!
        //! fd1.v2 = new Value(0); // Error: Can't
        //! fd1.VAL_3 = new Value(1); // change reference
        //! fd1.a = new int[3];
        print(fd1);
        print("Creating new FinalData");
        FinalData fd2 = new FinalData("fd2");
        print(fd1);
        print(fd2);
    }
} /* Output:
fd1: i4 = 15, INT_5 = 18
Creating new FinalData
fd1: i4 = 15, INT_5 = 18
fd2: i4 = 13, INT_5 = 18
*///:~
