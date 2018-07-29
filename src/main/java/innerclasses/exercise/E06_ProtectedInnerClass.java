package innerclasses.exercise;

import innerclasses.exercise.exercise6.SimpleInterface;
import innerclasses.exercise.exercise6b.SimpleClass;

/**
 * 练习6：继承第二个包里面的类，并在一个方法中返回该protected内部类的对象
 */
public class E06_ProtectedInnerClass extends SimpleClass {

	/**
	 * SimpleClass的子类，可以访问其protected修饰的内部类。向上转型为SimpleInterface接口类型
	 * @return
	 */
	public SimpleInterface get() {
		return new Inner();
	}

	public static void main(String args[]) {
		new E06_ProtectedInnerClass().get().f();
		// 也可以这样访问内部类中的方法
		new E06_ProtectedInnerClass().new Inner().f();
	}
}

class OtherClass {
	public static void main(String[] args) {
		// 没有继承SimpleClass类的类，不能访问SimpleClass中protected修饰的内部类
		// new E06_ProtectedInnerClass().new Inner().f();
	}
}