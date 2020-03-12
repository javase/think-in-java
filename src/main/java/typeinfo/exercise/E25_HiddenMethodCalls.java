package typeinfo.exercise;

import static net.mindview.util.Print.*;

import java.lang.reflect.Method;

import typeinfo.classa.A;

/**
 * 14.9 接口与类型信息
 * <pre>
 *     练习25: (2) 创建-一个包含private、 protected和包访问权限方法的类， 编写代码在该类所处的包的外部调用访问这些方法。
 * </pre>
 * created at 2020-03-12 07:59
 * @author lerry
 */
public class E25_HiddenMethodCalls {
	static void callHiddenMethod(Object a, String methodName) throws Exception {
		Method g = a.getClass().getDeclaredMethod(methodName);
		g.setAccessible(true);
		g.invoke(a);
	}

	public static void main(String[] args) throws Exception {
		class B extends A {
			@Override
			protected void b() {
				super.b();
			}
		}

		A objA = new A();
		// 直接通过接口调用包外的接口的非public方法，是行不通的
		//! objA.a();  Compile time error
		//! objA.b();  Compile time error
		//! objA.c();  Compile time error
		printlnf("通过反射调用外部包里面接口的非public方法");
		callHiddenMethod(objA, "a");
		callHiddenMethod(objA, "b");
		callHiddenMethod(objA, "c");

		printlnf("通过A接口的实现类B，调用重写的b()方法");
		B objB = new B();
		objB.b();
	}
}

