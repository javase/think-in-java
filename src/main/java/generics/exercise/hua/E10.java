package generics.exercise.hua;

import static net.mindview.util.Print.*;

/**
 * 15.4 泛型方法
 * 修改E09,使得f()其中一个参数修改为非参数化的类型
 * created at 2020-04-11 16:04
 * @author lerry
 */
public class E10 {

	public <T, A> void f(T t, A a, E10 b) {
		printlnf("T类型为：%s", t.getClass().getName());
		printlnf("A类型为：%s", a.getClass().getName());
		printlnf("B类型为：%s", b.getClass().getName());
	}

	public static void main(String[] args) {
		E10 e10 = new E10();
		e10.f("abc", 1, e10);
	}
}
/* Output:
T类型为：java.lang.String
A类型为：java.lang.Integer
B类型为：generics.exercise.hua.E10
 *///:~
