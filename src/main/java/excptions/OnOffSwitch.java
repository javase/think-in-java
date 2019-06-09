package excptions;//: exceptions/OnOffSwitch.java
// Why use finally?

// 为了确保off方法可以被执行，写到了很多个地方，可以使用finally改造
public class OnOffSwitch {
	private static Switch sw = new Switch();

	public static void f()
			throws OnOffException1, OnOffException2 {
	}

	public static void main(String[] args) {
		try {
			sw.on();
			// Code that can throw exceptions...
			f();
			sw.off();
		}
		catch (OnOffException1 e) {
			System.out.println("OnOffException1");
			sw.off();
		}
		catch (OnOffException2 e) {
			System.out.println("OnOffException2");
			sw.off();
		}
	}
} /* Output:
on
off
*///:~
