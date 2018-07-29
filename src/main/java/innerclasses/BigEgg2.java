package innerclasses;//: innerclasses/BigEgg2.java
// Proper inheritance of an inner class.

import static net.mindview.util.Print.*;

class Egg2 {

	protected class Yolk {
		public Yolk() {
			print("Egg2.Yolk() 蛋黄构造方法");
		}

		public void f() {
			print("Egg2.Yolk.f()  这是被继承的内部类的f方法");
		}
	}

	/**
	 * 一个Yolk类型的变量
	 */
	private Yolk y = new Yolk();

	public Egg2() {
		print("New Egg2() Egg2的构造方法");
	}

	public void insertYolk(Yolk yy) {
		y = yy;
	}

	public void g() {
		y.f();
	}
}

public class BigEgg2 extends Egg2 {

	/**
	 * 明确指出继承Yolk内部类
	 */
	public class Yolk extends Egg2.Yolk {
		public Yolk() {
			print("BigEgg2.Yolk()  继承了Yolk内部类的内部类的构造器");
		}

		@Override
		public void f() {
			print("BigEgg2.Yolk.f()  这是继承了内部类的类的f方法");
		}
	}

	public BigEgg2() {
		print("BigEgg2的无参构造器 接下里调用insertYolk()方法");
		insertYolk(new Yolk());
	}

	public static void main(String[] args) {
		Egg2 e2 = new BigEgg2();
		e2.g();
	}
} /* Output:
Egg2.Yolk()
New Egg2()
Egg2.Yolk()
BigEgg2.Yolk()
BigEgg2.Yolk.f()
*///:~
