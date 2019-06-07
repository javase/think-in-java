package excptions;//: exceptions/RethrowNew.java
// Rethrow a different object from the one that was caught.

import net.mindview.util.Print;

/**
 * 第一个自定义异常，继承自Exception类
 */
class OneException extends Exception {
	public OneException(String s) {
		super(s);
	}
}

/**
 * 第二个自定义异常，继承自Exception类
 */
class TwoException extends Exception {
	public TwoException(String s) {
		super(s);
	}
}

public class RethrowNew {

	/**
	 * 方法f，抛出OneException
	 * @throws OneException
	 */
	public static void f() throws OneException {
		System.out.println("originating the exception in f() method ");
		throw new OneException("thrown from f()");
	}

	public static void main(String[] args) {
		try {
			try {
				f();
			}
			catch (OneException e) {
				System.out.println(
						"Caught in inner try, e.printStackTrace()");
				e.printStackTrace(System.out);
				// 抛出新的异常
				throw new TwoException("from inner try ");
			}
		}
		catch (TwoException e) {
			Print.printlnf("-----------------------");
			System.out.println(
					"Caught in outer try, e.printStackTrace()");
			e.printStackTrace(System.out);
			Print.printlnf("会发现，原来有关异常发生点的信息会丢失");
		}
	}
} /* Output:
originating the exception in f() method
Caught in inner try, e.printStackTrace()
excptions.OneException: thrown from f()
	at excptions.RethrowNew.f(RethrowNew.java:30)
	at excptions.RethrowNew.main(RethrowNew.java:36)
Caught in outer try, e.printStackTrace()
excptions.TwoException: from inner try
	at excptions.RethrowNew.main(RethrowNew.java:43)
*///:~
