package typeinfo;//: typeinfo/ClassInitialization.java

import static net.mindview.util.Print.*;

import java.util.Random;

class Initable {
	static final int staticFinal = 47;

	static final int staticFinal2 =
			ClassInitialization.rand.nextInt(1000);

	static {
		System.out.println("Initializing Initable");
	}
}

class Initable2 {
	static int staticNonFinal = 147;

	static {
		System.out.println("Initializing Initable2");
	}
}

class Initable3 {
	static int staticNonFinal = 74;

	static {
		System.out.println("Initializing Initable3");
	}
}

/**
 * <pre>
 *     仅使用 .class 语法来获得对类的引用不会引发初始化
 *     Class.forName()立即就进行了初始化
 *     static final域，是"编译器常量"，这个值不需要初始化类，就可以被读取；
 *     但是如果域不是编译器常量，就会触发类的加载；
 *     如果一个static域不是final的，那么在对它访问时，总是要求它在被读取之前，要先进行链接（为这个域分配存储空间）和初始化（初始化该存储空间）。
 * </pre>
 */
public class ClassInitialization {
	public static Random rand = new Random(47);

	public static void main(String[] args) throws Exception {

		// 仅使用 .class 语法来获得对类的引用不会引发初始化
		Class initable = Initable.class;
		System.out.println("After creating Initable ref");

		// Does not trigger initialization:
		printlnf("Initable.staticFinal:%s", Initable.staticFinal);

		printALine();
		// Does trigger initialization:
		printlnf("Initable.staticFinal2:%s", Initable.staticFinal2);

		printALine();
		// Does trigger initialization:
		printlnf("Initable2.staticNonFinal:%s", Initable2.staticNonFinal);

		printALineDouble();
		Class initable3 = Class.forName("typeinfo.Initable3");
		System.out.println("After creating Initable3 ref");
		printlnf("Initable3.staticNonFinal:%s",Initable3.staticNonFinal);
	}
} /* Output:
After creating Initable ref
47
Initializing Initable
258
Initializing Initable2
147
Initializing Initable3
After creating Initable3 ref
74
*///:~
