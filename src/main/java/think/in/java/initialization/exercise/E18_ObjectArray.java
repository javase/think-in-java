package think.in.java.initialization.exercise;

/**
 * Created by limenghua on 2017/6/4.
 */
public class E18_ObjectArray {
    public static void main(String args[]) {
        Test[] array = new Test[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Test(Integer.toString(i));
        }
    }
} /* Output:
String constructor; s = 0
String constructor; s = 1
String constructor; s = 2
String constructor; s = 3
String constructor; s = 4
*///:~