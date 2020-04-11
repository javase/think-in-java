package generics.exercise;

import static net.mindview.util.Print.*;

/**
 * 15.4 泛型方法
 * 修改GenericMethods,使得f()可以接收三个类型各不相同的参数
 * created at 2020-04-11 16:20
 * @author lerry
 */
public class E09_GenericMethods2 {

	public <A, B, C> void f(A a, B b, C c) {
		System.out.println(a.getClass().getName());
		System.out.println(b.getClass().getName());
		System.out.println(c.getClass().getName());
		printALine();
	}

	public static void main(String[] args) {
		E09_GenericMethods2 gm = new E09_GenericMethods2();
		gm.f("", 1, 1.0);
		gm.f(1.0F, 'c', gm);
	}
}
/* Output:
java.lang.String
java.lang.Integer
java.lang.Double
---------------------------------------------------------------------------
java.lang.Float
java.lang.Character
generics.exercise.E09_GenericMethods2
---------------------------------------------------------------------------
 *///:~