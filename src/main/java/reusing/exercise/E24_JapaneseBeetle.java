package reusing.exercise;

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
class Beetle extends Insect {
	private int k = printInit("（1）甲虫子类成员变量 Beetle.k initialized");

	public Beetle() {
		print("（2）甲虫子类构造方法 k = " + k);
		print("（2）甲虫子类构造方法 j = " + j);
	}

	private static int x2 =
			printInit("甲虫子类静态成员变量 static Beetle.x2 initialized");

	public static void main(String[] args) {
		print("Beetle constructor");
		Beetle b = new Beetle();
	}
}

class JapaneseBeetle extends Beetle {
	int m = printInit("（1）日本甲虫普通成员变量 JapaneseBeetle.m initialized");

	JapaneseBeetle() {
		print("（2）日本甲虫构造器 m = " + m);
		print("（2）日本甲虫构造器 j = " + j);
	}

	static int x3 =
			printInit("日本甲虫的静态成员变量 static JapaneseBeetle.x3 initialized");
}

public class E24_JapaneseBeetle {
	public static void main(String args[]) {
		new JapaneseBeetle();
	}
}