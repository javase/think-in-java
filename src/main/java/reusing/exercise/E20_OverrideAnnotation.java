package reusing.exercise;

/**
 * Created by limenghua on 2017/10/27.
 * @author limenghua
 */

import static net.mindview.util.Print.*;

class WithFinals {
	// Identical to "private" alone:
	private final void f() {
		print("WithFinals.f()");
	}

	// Also automatically "final":
	private void g() {
		print("WithFinals.g()");
	}
}

class OverridingPrivateE20 extends WithFinals {
	//@Override
	private final void f() {
		print("OverridingPrivateE20.f()");
	}

	//@Override
	private void g() {
		print("OverridingPrivateE20.g()");
	}
}

class OverridingPrivate2E20 extends OverridingPrivateE20 {
	//@Override
	public final void f() {
		print("OverridingPrivate2E20.f()");
	}

	//@Override
	public void g() {
		print("OverridingPrivate2E20.g()");
	}
}

public class E20_OverrideAnnotation {
	public static void main(String[] args) {
		OverridingPrivate2E20 op2 = new OverridingPrivate2E20();
		op2.f();
		op2.g();
	}
} ///:~

