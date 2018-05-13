package think.in.java.interfaces.exercise;

/**
 * 第一个接口
 */
interface BaseInterface {
	void f();
}

interface IntermediateInterface1 extends BaseInterface {
	@Override
	void f();
}

interface IntermediateInterface2 extends BaseInterface {
	@Override
	void f();
}

/**
 * 多重继承接口
 */
interface CombinedInterface
		extends IntermediateInterface1, IntermediateInterface2 {
	@Override
	void f();
}

class CombinedImpl implements CombinedInterface {
	@Override
	public void f() {
		System.out.println("CombinedImpl.f()");
	}
}

/**
 * 创建一个接口，并从该接口继承两个接口，然后从后面两个接口多重继承第三个接口
 */
public class E13_Diamond {
	public static void main(String[] args) {
		new CombinedImpl().f();
	}
} /* Output:
		 CombinedImpl.f()
         *///:~