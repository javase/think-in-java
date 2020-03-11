package typeinfo;//: typeinfo/HiddenImplementation.java
// Sneaking around package access.

import static net.mindview.util.Print.*;

import java.lang.reflect.Method;

import typeinfo.interfacea.A;
import typeinfo.packageaccess.HiddenC;

/**
 * 14.9 接口与类型信息
 * created at 2020-03-12 07:13
 * @author lerry
 */
public class HiddenImplementation {
	public static void main(String[] args) throws Exception {
		A a = HiddenC.makeA();
		printlnf("调用接口A的方法，因为被C子类实现，转而调用C的该重写方法");
		a.f();
		System.out.println(a.getClass().getName());
		// Compile error: cannot find symbol 'C':
		// 此时，拥有包级别访问限制的C，在包外是不可见的
    /* if(a instanceof C) {
      C c = (C)a;
      c.g();
    } */
		// Oops! Reflection still allows us to call g():
		callHiddenMethod(a, "g");
		// And even methods that are less accessible!
		callHiddenMethod(a, "u");
		callHiddenMethod(a, "v");
		callHiddenMethod(a, "w");
	}

	/**
	 * 通过反射，我们依然可以调用拥有包级别保护的C类的方法，甚至是private方法
	 * @param a
	 * @param methodName
	 * @throws Exception
	 */
	static void callHiddenMethod(Object a, String methodName) throws Exception {
		Method g = a.getClass().getDeclaredMethod(methodName);
		g.setAccessible(true);
		g.invoke(a);
	}
} /* Output:
public C.f()
typeinfo.packageaccess.C
public C.g()
package C.u()
protected C.v()
private C.w()
*///:~
