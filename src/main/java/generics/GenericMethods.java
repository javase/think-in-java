package generics;//: generics/GenericMethods.java

import static net.mindview.util.Print.*;

/**
 * 15.4 泛型方法
 * created at 2020-04-11 15:43
 * @author lerry
 */
public class GenericMethods {

	/**
	 * 泛型方法的示例
	 * 其中<T>是为了定义当前我有一个 范型变量类型，类型名使用T来表示
	 * @param x
	 * @param <T>
	 */
	public <T> void f(T x) {
		System.out.println(x.getClass().getName());
	}

	public <T> T f1(T x1) {
		printlnf("方法中传递过来的参数，类型是动态的，当前参数类型为：%s", x1.getClass().getSimpleName());
		return x1;
	}

	public static void main(String[] args) {
		GenericMethods gm = new GenericMethods();
		gm.f("");
		gm.f(1);
		gm.f(1.0);
		gm.f(1.0F);
		gm.f('c');
		gm.f(gm);

		printALineDouble();

		gm.f1("");
		gm.f1(1);
		gm.f1(1.0);
		gm.f1(1.0F);
		gm.f1('c');
		gm.f1(gm);
	}
} /* Output:
java.lang.String
java.lang.Integer
java.lang.Double
java.lang.Float
java.lang.Character
GenericMethods
*///:~
