package innerclasses.exercise;

import innerclasses.exercise.exercise6.SimpleInterface;

/**
 * 匿名内部类的使用
 */
public class E13_AnonymousInnerClassInMethod {

	public SimpleInterface get() {

		return new SimpleInterface() {
			@Override
			public void f() {
				System.out.println("SimpleInterface.f");
			}
		};
	}

	public static void main(String args[]) {
		SimpleInterface si =
				new E13_AnonymousInnerClassInMethod().get();
		si.f();
	}
} /* Output:
		 SimpleInterface.f
         *///:~