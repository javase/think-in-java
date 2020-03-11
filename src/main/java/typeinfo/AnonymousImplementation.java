package typeinfo;//: typeinfo/AnonymousImplementation.java
// Anonymous inner classes can't hide from reflection.

import static net.mindview.util.Print.*;

import typeinfo.interfacea.A;

/**
 * 14.9 接口与类型信息
 * 实现A接口为匿名内部类，来测试匿名内部类的私有方法能否被反射调用。答案是肯定的，可以被调用。
 * created at 2020-03-12 07:24
 * @author lerry
 */
public class AnonymousImplementation {
	public static void main(String[] args) throws Exception {
		A a = AnonymousA.makeA();
		a.f();
		System.out.println(a.getClass().getName());
		// Reflection still gets into the anonymous class:
		HiddenImplementation.callHiddenMethod(a, "g");
		HiddenImplementation.callHiddenMethod(a, "u");
		HiddenImplementation.callHiddenMethod(a, "v");
		HiddenImplementation.callHiddenMethod(a, "w");
	}
}

class AnonymousA {
	public static A makeA() {
		return new A() {
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
		};
	}
}

 /* Output:
public C.f()
AnonymousA$1
public C.g()
package C.u()
protected C.v()
private C.w()
*///:~
