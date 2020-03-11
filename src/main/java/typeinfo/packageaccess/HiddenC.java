//: typeinfo/packageaccess/HiddenC.java
package typeinfo.packageaccess;

import static net.mindview.util.Print.*;

import typeinfo.interfacea.A;

/**
 * 14.9 接口与类型信息
 * 使用包限定，使得包的外部，不能使用A之外的方法
 * created at 2020-03-12 07:10
 * @author lerry
 */
public class HiddenC {
	public static A makeA() {
		return new C();
	}
}

/**
 * 拥有包级别的访问限制
 */
class C implements A {
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

///:~
