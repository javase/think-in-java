package think.in.java.polymorphism;//: polymorphism/StaticPolymorphism.java
// Static methods are not polymorphic.

import static net.mindview.util.Print.print;

class StaticSuper {
	public static String staticGet() {
		return "Base staticGet()";
	}

	public String dynamicGet() {
		return "Base dynamicGet()";
	}
}

class StaticSub extends StaticSuper {
	// @Override 覆盖静态方法会报错
	public static String staticGet() {
		return "Derived staticGet()";
	}

	@Override
	public String dynamicGet() {
		return "Derived dynamicGet()";
	}
}

/**
 * 如果某个方法是静态的，它的行为就不具有多态性
 * 静态方法是与类，而并非与单个的对象相关联的
 */
public class StaticPolymorphism {
	public static void main(String[] args) {
		StaticSuper sup = new StaticSub(); // Upcast
		print(StaticSuper.staticGet());
		print(sup.dynamicGet());
	}
} /* Output:
Base staticGet()
Derived dynamicGet()
*///:~
