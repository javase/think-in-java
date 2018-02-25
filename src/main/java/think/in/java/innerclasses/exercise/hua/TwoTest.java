package think.in.java.innerclasses.exercise.hua;

import static net.mindview.util.Print.print;

/**
 * 匿名内部类实现的接口，可以包含多个方法
 * Created by limenghua on 2018/2/25.
 * @author limenghua
 */
interface InterfaceTwoMethod {
	void f1();

	void f2();
}

public class TwoTest {
	public InterfaceTwoMethod getInterface() {
		// 匿名内部类实现的接口，可以包含多个方法
		return new InterfaceTwoMethod() {
			public void f1() {
				print("method1");

			}

			public void f2() {
				print("method2");
			}
		};
	}

	public static void main(String[] args) {
		TwoTest twoTest = new TwoTest();
		twoTest.getInterface().f1();
		twoTest.getInterface().f2();
	}
}
