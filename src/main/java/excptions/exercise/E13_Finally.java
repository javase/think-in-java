package excptions.exercise;

/**
 * 虽然代码没有捕获NullPointerException，但它仍然执行finally子句。
 */
public class E13_Finally {
	/**
	 * 该方法抛出空指针异常
	 */
	public static void throwNull() {
		throw new NullPointerException();
	}

	public static void main(String args[]) {
		Thrower2 t = new Thrower2();

		try {
			t.f();
		}
		catch (ExBase e) {
			System.err.println("caught " + e);
		}
		finally {
			System.out.println("In finally clause A");
		}

		try {
			throwNull();
			t.f();
		}
		catch (ExBase e) {
			System.err.println("caught " + e);
		}
		finally {
			// 虽然代码没有捕获NullPointerException，但它仍然执行finally子句。
			System.out.println("In finally clause B");
		}
	}
}