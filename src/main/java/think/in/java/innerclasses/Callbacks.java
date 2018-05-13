//: innerclasses/Callbacks.java
// Using inner classes for callbacks
package think.in.java.innerclasses;

import static net.mindview.util.Print.*;

interface Incrementable {
	/**
	 * Increment 增长
	 */
	void increment();
}

/**
 * Very simple to just implement the interface:
 * 简单地实现一个接口
 */
class Callee1ImpInterface implements Incrementable {
	private int i = 0;

	@Override
	public void increment() {
		i++;
		print(i);
	}
}

/**
 * 一个基类，也有一个increment方法
 */
class BaseMyIncrement {
	public void increment() {
		print("Other operation");
	}

	/**
	 * 调用自身的increment方法
	 * @param mi
	 */
	static void f(BaseMyIncrement mi) {
		mi.increment();
	}
}

/**
 * If your class must implement increment() in
 *  some other way, you must use an inner class:
 *  如果你的类必须以某种方式实现increment()，你必须使用一个内部类（这个类继承了一个基类，同时又想实现某个接口）
 */
class Callee2ExtendsBaseClassContainsInnerClass extends BaseMyIncrement {
	private int i = 0;

	@Override
	public void increment() {
		// 调用基类的increment()方法
		super.increment();
		i++;
		print(i);
	}

	private class Closure implements Incrementable {
		@Override
		public void increment() {
			// Specify outer-class method, otherwise
			// you'd get an infinite（无限的） recursion:
			// 调用外部类的方法
			Callee2ExtendsBaseClassContainsInnerClass.this.increment();
		}
	}

	/**
	 * 获得Incrementable对象
	 * @return
	 */
	Incrementable getCallbackReference() {
		return new Closure();
	}
}

/**
 * 调用者，调用Incrementable接口的increment()方法
 * 持有Incrementable接口类型对象
 */
class Caller {
	private Incrementable callbackReference;

	Caller(Incrementable cbh) {
		callbackReference = cbh;
	}

	/**
	 * 调用接口对象的increment()方法
	 */
	void go() {
		callbackReference.increment();
	}
}


public class Callbacks {
	public static void main(String[] args) {
		Callee1ImpInterface c1 = new Callee1ImpInterface();
		Callee2ExtendsBaseClassContainsInnerClass c2 = new Callee2ExtendsBaseClassContainsInnerClass();
		BaseMyIncrement.f(c2);

		Caller caller1 = new Caller(c1);
		Caller caller2 = new Caller(c2.getCallbackReference());

		caller1.go();
		caller1.go();

		caller2.go();
		caller2.go();
	}
} /* Output:
Other operation
1
1
2
Other operation
2
Other operation
3
*///:~
