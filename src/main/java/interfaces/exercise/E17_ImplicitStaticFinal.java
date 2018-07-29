package interfaces.exercise;

interface StaticFinalTest {
	String RED = "Red";
}

class Test implements StaticFinalTest {
	public Test() {
		// 是final的，不可改变
		// Compile-time error: cannot assign a value
		// to final variable RED:
		//!  RED = "Blue";
	}
}

public class E17_ImplicitStaticFinal {
	public static void main(String args[]) {
		// Accessing as a static field:
		System.out.println("StaticFinalTest.RED = "
				+ StaticFinalTest.RED);
	}
}