package excptions;//: exceptions/NeverCaught.java
// Ignoring RuntimeExceptions.
// {ThrowsException}

/**
 * <pre>
 * RuntimeException属于错误、将被自动捕获。属于“不受检查的异常”。
 * 对于这种异常，编译器不需要异常说明，其输出被报告给了System.err
 * </pre>
 */
public class NeverCaught {
	static void f() {
		throw new RuntimeException("From f()");
	}

	static void g() {
		f();
	}

	public static void main(String[] args) {
		g();
	}
} ///:~
