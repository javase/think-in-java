package think.in.java.innerclasses;//: innerclasses/BigEgg.java
// An inner class cannot be overriden like a method.

import static net.mindview.util.Print.*;

class Egg {
	private Yolk y;

	protected class Yolk {

		public Yolk() {
			print("Egg.Yolk() 鸡蛋的蛋黄 构造方法");
		}
	}

	public Egg() {
		print("New Egg() 接下来创建一个蛋黄对象");
		y = new Yolk();
	}
}

/**
 * 两个内部类是完全独立的两个实体，各自在自己的命名空间内
 */
public class BigEgg extends Egg {
	/**
	 * 我们发现，内部类并没有被覆盖
	 */
	public class Yolk {
		public Yolk() {
			print("BigEgg.Yolk() 大鸡蛋的蛋黄 构造方法");
		}
	}

	public static void main(String[] args) {
		new BigEgg();
	}
} /* Output:
New Egg()
Egg.Yolk()
*///:~
