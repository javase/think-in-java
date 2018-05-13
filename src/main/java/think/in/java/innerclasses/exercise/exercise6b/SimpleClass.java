package think.in.java.innerclasses.exercise.exercise6b;

import think.in.java.innerclasses.exercise.exercise6.SimpleInterface;

/**
 * 练习6：在第二个包里面创建一个类，在其中添加一个protected的内部类并实现第一个包里的接口
 */
public class SimpleClass {
	/**
	 * 实现了SimpleInterface接口
	 */
	protected class Inner implements SimpleInterface {
		// Force constructor to be public:
		public Inner() {
		}

		@Override
		public void f() {
		}
	}
}