package think.in.java.innerclasses.exercise;

import static net.mindview.util.Print.print;

class Outer {
	/**
	 * 一个内部类
	 */
	class Inner {
		{ print("Inner created\n"); }
	}

	Inner getInner() {
		print("创建内部类实例");
		return new Inner();
	}

	public void method() {
		print("外部类的非静态方法");
		// 在外部类的非静态方法之内，可以直接引用内部类
		Inner i = getInner();
	}

	public static void main(String[] args) {
		// 在外部类的静态方法之内，也可以直接引用内部类
		Inner i = new Outer().getInner();
		new Outer().method();
	}
}

public class E01_ReferenceToInnerClass {
	public static void main(String[] args) {
		Outer o = new Outer();
		// 在外部类的非静态方法之外的任意位置创建某个内部类的对象，需要具体指明这个对象的类型： Outer.Inner
		print("在其他地方（非外部类范围内）创建内部类");
		Outer.Inner i = o.getInner();
	}
}