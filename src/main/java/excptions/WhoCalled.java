package excptions;//: exceptions/WhoCalled.java
// Programmatic access to stack trace information.

import net.mindview.util.Print;

public class WhoCalled {
	static void f() {
		// Generate an exception to fill in the stack trace
		try {
			throw new Exception();
		}
		catch (Exception e) {
			for (StackTraceElement stackTraceElement : e.getStackTrace()) {
//				Print.printlnf("methodName：%s", stackTraceElement.getMethodName());
				Print.printlnf("stackTraceElement：%s", stackTraceElement);
			}
		}
	}

	static void g() {
		f();
	}

	static void h() {
		g();
	}

	public static void main(String[] args) {
		f();
		System.out.println("--------------------------------");
		g();
		System.out.println("--------------------------------");
		h();
	}
} /* Output:
f
main
--------------------------------
f
g
main
--------------------------------
f
g
h
main
*///:~
