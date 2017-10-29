package think.in.java.polymorphism;//: polymorphism/FieldAccess.java
// Direct field access is determined at compile time.

import static net.mindview.util.Print.print;

class Super {
	// 父类的公共域
	public int field = 0;

	public int getField() {
		return field;
	}
}

class Sub extends Super {
	public int field = 1;

	@Override
	public int getField() {
		return field;
	}

	public int getSuperField() {
		return super.field;
	}
}

/**
 * 只有普通的方法调用可以是多态的
 */
public class FieldAccess {
	public static void main(String[] args) {
		Super sup = new Sub(); // Upcast
		// 域并不是多态的，这里打印出来是父类的域
		print("sup.field = " + sup.field +
				", sup.getField() = " + sup.getField());
		Sub sub = new Sub();
		print("sub.field = " +
				sub.field + ", sub.getField() = " +
				sub.getField() +
				", sub.getSuperField() = " +
				sub.getSuperField());
	}
} /* Output:
sup.field = 0, sup.getField() = 1
sub.field = 1, sub.getField() = 1, sub.getSuperField() = 0
*///:~
