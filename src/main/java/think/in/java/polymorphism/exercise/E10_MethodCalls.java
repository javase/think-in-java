package think.in.java.polymorphism.exercise;

import static net.mindview.util.Print.print;

/**
 * Created by limenghua on 2017/10/29.
 * @author limenghua
 */
class TwoMethods {
	public void m1() {
		print("Inside m1, calling m2");
		m2();
	}

	public void m2() {
		print("父类方法 Inside m2");
	}
}

class Inherited extends TwoMethods {
//	@Override
//	public void m1() {
//		print("子类方法m1()");
//		m2();
//	}

	@Override
	public void m2() {
		print("子类方法 Inside Inherited.m2");
	}
}

/**
 * 第一个方法没有被覆盖，但是它调用第二个方法，也就是:
 * Java总是为对象类型使用最派生的方法;
 * 这是非常强大的(可能会让不知道的人大吃一惊)。
 * 模板方法设计模式大量使用了多态性。
 */
public class E10_MethodCalls {
	public static void main(String args[]) {
		// 没有找到子类的覆盖，所以就调用了父类的m1方法
		TwoMethods x = new Inherited();
		print(x.getClass());
		x.m1();

		print("===============");

		Inherited t = new Inherited();
		print(t.getClass());
		t.m1();

		print("===============");
		TwoMethods two = new TwoMethods();
		print(two.getClass());
		two.m1();

	}
}
