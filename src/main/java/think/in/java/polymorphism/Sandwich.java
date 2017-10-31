//: polymorphism/Sandwich.java
// Order of constructor calls.
package think.in.java.polymorphism;

import static net.mindview.util.Print.*;

class Meal {
	Meal() {
		print("Meal()");
	}
}

class Bread {
	Bread() {
		print("Bread()");
	}
}

class Cheese {
	Cheese() {
		print("Cheese()");
	}
}

class Lettuce {
	Lettuce() {
		print("Lettuce()");
	}
}

class Lunch extends Meal {
	Lunch() {
		print("Lunch()");
	}
}

class PortableLunch extends Lunch {
	PortableLunch() {
		print("PortableLunch()");
	}
}

/**
 * 探究构造器的执行顺序
 * 1.调用基类构造器
 * 2.按声明顺序调用成员的初始化方法
 * 3.调用导出类的构造器主体
 */
public class Sandwich extends PortableLunch {
	private Bread b = new Bread();

	private Cheese c = new Cheese();

	private Lettuce l = new Lettuce();

	public Sandwich() {
		print("Sandwich()");
	}

	public static void main(String[] args) {
		new Sandwich();
	}
} /* Output:
Meal()
Lunch()
PortableLunch()
Bread()
Cheese()
Lettuce()
Sandwich()
*///:~
