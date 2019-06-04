package excptions;//: exceptions/FullConstructors.java

/**
 * 带有可以接受字符串参数的构造器
 */
class MyException extends Exception {
	public MyException() {
	}

	public MyException(String msg) {
		super(msg);
	}
}

public class FullConstructors {
	public static void f() throws MyException {
		System.out.println("Throwing MyException from f()");
		throw new MyException();
	}

	public static void g() throws MyException {
		System.out.println("Throwing MyException from g()");
		throw new MyException("Originated in g()");
	}

	public static void main(String[] args) {
		try {
			f();
		}
		catch (MyException e) {
			e.printStackTrace(System.out);
		}
		try {
			g();
		}
		catch (MyException e) {
			// 错误信息输出到System.out
			e.printStackTrace(System.out);
//			e.printStackTrace();
		}
	}
} /* Output:
Throwing MyException from f()
MyException
        at FullConstructors.f(FullConstructors.java:11)
        at FullConstructors.main(FullConstructors.java:19)
Throwing MyException from g()
MyException: Originated in g()
        at FullConstructors.g(FullConstructors.java:15)
        at FullConstructors.main(FullConstructors.java:24)
*///:~
