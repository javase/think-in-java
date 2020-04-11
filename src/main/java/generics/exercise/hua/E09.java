package generics.exercise.hua;

import static net.mindview.util.Print.*;

/**
 * 15.4 泛型方法
 * 修改GenericMethods,使得f()可以接收三个类型各不相同的参数
 * created at 2020-04-11 16:04
 * @author lerry
 */
public class E09 {

	public <T, A, B> void f(T t, A a, B b) {
		printlnf("T类型为：%s", t.getClass().getName());
		printlnf("A类型为：%s", a.getClass().getName());
		printlnf("B类型为：%s", b.getClass().getName());
	}

	public static void main(String[] args) {
		E09 e09 = new E09();
		e09.f("abc", 1, e09);
	}
}
/* Output:
T类型为：java.lang.String
A类型为：java.lang.Integer
B类型为：generics.exercise.hua.E09
 *///:~
