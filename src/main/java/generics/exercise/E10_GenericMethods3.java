package generics.exercise;

/**
 * 15.4 泛型方法
 * 修改E09_GenericMethods2类,使得f()其中一个参数修改为非参数化的类型
 * created at 2020-04-11 16:22
 * @author lerry
 */
public class E10_GenericMethods3 {
	public <A, B> void f(A a, B b, Boolean c) {
		System.out.println(a.getClass().getName());
		System.out.println(b.getClass().getName());
		System.out.println(c.getClass().getName());
	}

	public static void main(String[] args) {
		E10_GenericMethods3 gm = new E10_GenericMethods3();
		gm.f("", 1, true);
		gm.f(1.0, 1.0F, false);
		gm.f('c', gm, true);
	}
} /* Output:
         java.lang.String
         java.lang.Integer
         java.lang.Boolean
         java.lang.Double
         java.lang.Float
         java.lang.Boolean
         java.lang.Character
         generics.E10_GenericMethods3
         java.lang.Boolean
         *///:~