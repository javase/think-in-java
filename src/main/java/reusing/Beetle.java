package reusing;//: reusing/Beetle.java
// The full process of initialization.

import static net.mindview.util.Print.*;

/**
 * 昆虫
 */
class Insect {
	private int i = 9;

	protected int j;

	Insect() {
		print("父类构造器i = " + i + ", j = " + j);
		j = 39;
	}

	private static int x1 =
			printInit("父类静态成员变量 static Insect.x1 initialized");

	static int printInit(String s) {
		print("父类静态方法 \t" + s);
		return 47;
	}
}

/**
 * 甲虫  是 一种昆虫
 */
public class Beetle extends Insect {
	private int k = printInit("子类成员变量 Beetle.k initialized");

	public Beetle() {
		print("子类构造方法 k = " + k);
		print("子类构造方法 j = " + j);
	}

	private static int x2 =
			printInit("子类静态成员变量 static Beetle.x2 initialized");

	public static void main(String[] args) {
		print("Beetle constructor");
		Beetle b = new Beetle();
	}
} /* Output:
static Insect.x1 initialized
static Beetle.x2 initialized
Beetle constructor
i = 9, j = 0
Beetle.k initialized
k = 47
j = 39
*///:~


