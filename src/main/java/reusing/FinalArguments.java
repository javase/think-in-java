package reusing;//: reusing/FinalArguments.java
// Using "final" with method arguments.

class Gizmo {
	public void spin() {
		System.out.println("旋转");
	}
}

public class FinalArguments {
	void with(final Gizmo g) {
		//! g = new Gizmo(); // Illegal -- g is final
		// g = new Gizmo();  // 会报语法错误  "Cannot assign a value to final variable 'g'"
	}

	void without(Gizmo g) {
		g = new Gizmo(); // OK -- g not final
		g.spin();
	}

	// void f(final int i) { i++; } // Can't change
	// You can only read from a final primitive:
	int g(final int i) {  // 可以读取final 变量的值
		return i + 1;
	}

	public static void main(String[] args) {
		FinalArguments bf = new FinalArguments();
		bf.without(null);
		bf.with(null);
	}
} ///:~
