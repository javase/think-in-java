package think.in.java.innerclasses.exercise;

import static net.mindview.util.Print.print;

class WithNonDefault {
	/**
	 * 该内部类有一个非默认的构造器
	 */
	class Inner {
		int i;

		public Inner(int i) {
			print("Inner内部类的构造有参方法");
			this.i = i;
		}

		public Inner() {
			i = 47;
		}

		public void f() {
			print("Inner.f");
		}
	}
}

/**
 * 也包含一个内部类，此内部类继承自Inner内部类
 */
public class E26_InnerClassInheritance {

	class Inner2 extends WithNonDefault.Inner {
		// Won't compile -- WithNonDefault not available:
		//! public Inner2(int i) {
		//!   super(i);
		//! }
		public Inner2(WithNonDefault wnd, int i) {
			wnd.super(i);
			print("Inner继承了一个内部类的内部类的构造方法");
		}

		@Override
		public void f() {
			print("Inner2.f");
			super.f();
		}
	}

	public static void main(String args[]) {
		WithNonDefault wnd = new WithNonDefault();
		E26_InnerClassInheritance ici =
				new E26_InnerClassInheritance();
		Inner2 i2 = ici.new Inner2(wnd, 47);
		i2.f();
	}
}