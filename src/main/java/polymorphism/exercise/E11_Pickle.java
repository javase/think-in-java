package polymorphism.exercise;

import static net.mindview.util.Print.print;

/**
 * 在三明治基础上，加上Pickle类，观察构造器执行过程
 * Created by limenghua on 2017/10/30.
 * @author limenghua
 */
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

class Pickle {
	Pickle() {
		print("Pickle()");
	}
}

class Sandwich2 extends PortableLunch {
	Bread b = new Bread();

	Cheese c = new Cheese();

	Lettuce l = new Lettuce();

	Pickle p = new Pickle();

	Sandwich2() {
		print("Sandwich()");
	}
}

public class E11_Pickle {
	public static void main(String args[]) {
		new Sandwich2();
	}
}
