package think.in.java.interfaces.exercise;

/**
 * Created by limenghua on 2017/11/1.
 * @author limenghua
 */
abstract class NoMethods {
}

class Extended1 extends NoMethods {
	public void f() {
		System.out.println("Extended1.f");
	}
}

abstract class WithMethods {
	abstract public void f();
}

class Extended2 extends WithMethods {
	public void f() {
		System.out.println("Extended2.f");
	}
}

public class E04_AbstractBase {
	/**
	 * 需要向下转型
	 * @param nm
	 */
	public static void test1(NoMethods nm) {
		// Must downcast to access f():
		((Extended1) nm).f();
	}

	/**
	 * 不需要向下转型
	 * @param wm
	 */
	public static void test2(WithMethods wm) {
		// No downcast necessary:
		wm.f();
	}

	public static void main(String args[]) {
		NoMethods nm = new Extended1();
		test1(nm);
		WithMethods wm = new Extended2();
		test2(wm);
	}
}
