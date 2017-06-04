package think.in.java.initialization.exercise;

/**
 * Created by limenghua on 2017/6/4.
 */
class Test {
    Test(String s) {
        System.out.println("一参构造器 String constructor; s = " + s);
    }
}

public class E17_ObjectReferences {
    // You can define the array as a field in the class:
    Test[] array1 = new Test[5];

    public static void main(String args[]) {
        // Or as a temporary inside main:
        Test[] array2 = new Test[5];
    }
} ///:~
