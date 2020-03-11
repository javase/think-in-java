package typeinfo;//: typeinfo/InnerImplementation.java
// Private inner classes can't hide from reflection.

import static net.mindview.util.Print.*;

import typeinfo.interfacea.A;

/**
 * 14.9 接口与类型信息
 * created at 2020-03-12 07:23
 * @author lerry
 */
public class InnerImplementation {
	public static void main(String[] args) throws Exception {
		A a = InnerA.makeA();
		a.f();
		System.out.println(a.getClass().getName());
		// Reflection still gets into the private class:
		HiddenImplementation.callHiddenMethod(a, "g");
		HiddenImplementation.callHiddenMethod(a, "u");
		HiddenImplementation.callHiddenMethod(a, "v");
		HiddenImplementation.callHiddenMethod(a, "w");
	}
}

class InnerA {

	/**
	 * 把A接口实现为一个私有内部类
	 * created at 2020-03-12 07:23
	 * @author lerry
	 */
	private static class C implements A {
		@Override
		public void f() {
			print("public C.f()");
		}

		public void g() {
			print("public C.g()");
		}

		void u() {
			print("package C.u()");
		}

		protected void v() {
			print("protected C.v()");
		}

		private void w() {
			print("private C.w()");
		}
	}

	public static A makeA() {
		return new C();
	}
}

/* Output:
public C.f()
InnerA$C
public C.g()
package C.u()
protected C.v()
private C.w()
*///:~
