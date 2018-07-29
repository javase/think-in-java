package innerclasses.exercise;

import innerclasses.exercise.exercise6.SimpleInterface;

public class E09_InnerClassInMethod {

	// 方法内部定义一个内部类，该方法返回对某接口的引用
	public SimpleInterface get() {

		// 局部内部类实现了上述方法返回的接口
		class SI implements SimpleInterface {
			@Override
			public void f() {
				System.out.println("SI.f");
			}
		}
		return new SI();

	}

	public static void main(String args[]) {
		SimpleInterface si =
				new E09_InnerClassInMethod().get();
		si.f();
	}
} /* Output:
		 SI.f
         *///:~
