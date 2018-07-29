package innerclasses.exercise;

/**
 * 一个没有默认构造器的类
 */
class NoDefault {
	private int i;

	public NoDefault(int i) {
		this.i = i;
	}

	public void f() {
		System.out.println("NoDefault.f()");
	}
}

/**
 * 包含能返回第一个类的对象的引用 的方法
 */
class Second {

	public NoDefault get1(int i) {
		// Doesn't override any methods:
		return new NoDefault(i) {
		};
	}

	public NoDefault get2(int i) {
		// Overrides f():
		return new NoDefault(i) {
			@Override
			public void f() {
				System.out.println("重写了第一个类的f()方法");
			}
		};
	}
}

public class E15_ReturningAnonymousIC {
	public static void main(String args[]) {

		Second sec = new Second();
		NoDefault nd = sec.get1(47);
		nd.f();

		nd = sec.get2(99);
		nd.f();
	}
}