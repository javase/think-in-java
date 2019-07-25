package reusing;//: reusing/Bath.java
// Constructor initialization with composition.

import static net.mindview.util.Print.*;

/**
 * 肥皂
 */
class Soap {
    private String s;

    Soap() {
        print("Soap()");
        s = "Constructed";// 在构造器初始化
    }

    @Override
    public String toString() {
        return s;
    }
}

/**
 * 洗澡
 */
public class Bath {
    private String // Initializing at point of definition:
            s1 = "Happy", // 在定义的时候初始化
            s2 = "Happy",
            s3, s4;
    private Soap castille;
    private int i;
    private float toy;

    public Bath() {
        print("Inside Bath()");
        s3 = "Joy";
        toy = 3.14f;
        castille = new Soap();
    }

    // Instance initialization:
    {
        i = 47;
    }

    @Override
    public String toString() {
        if (s4 == null) // Delayed initialization:  在使用的时候初始化
		{
			s4 = "Joy";
		}
        return
                "s1 = " + s1 + "\n" +
                        "s2 = " + s2 + "\n" +
                        "s3 = " + s3 + "\n" +
                        "s4 = " + s4 + "\n" +
                        "i = " + i + "\n" +
                        "toy = " + toy + "\n" +
                        "castille = " + castille;
    }

    public static void main(String[] args) {
        Bath b = new Bath();// 实例初始化
        print(b);
    }
} /* Output:
Inside Bath()
Soap()
s1 = Happy
s2 = Happy
s3 = Joy
s4 = Joy
i = 47
toy = 3.14
castille = Constructed
*///:~
