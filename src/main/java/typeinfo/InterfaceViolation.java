package typeinfo;//: typeinfo/InterfaceViolation.java
// Sneaking around an interface.

import static net.mindview.util.Print.*;

import typeinfo.interfacea.A;

/**
 * 14.9 接口与类型信息
 * 通过接口实现，我们可以调用不在顶层接口A中的方法
 * created at 2020-03-12 07:07
 * @author lerry
 */
public class InterfaceViolation {
	public static void main(String[] args) {
		A a = new B();
		a.f();
		// a.g(); // Compile error
		System.out.println(a.getClass().getName());
		if (a instanceof B) {
			B b = (B) a;
			b.g();
		}


	}
}

/**
 * 实现了A接口，并重写了A中的f()方法
 * created at 2020-03-12 07:07
 * @author lerry
 */
class B implements A {
	@Override
	public void f() {
	}

	public void g() {
		printlnf("%s.g()被调用了", this.getClass().getSimpleName());
	}
}

 /* Output:
B
*///:~
