package generics;//: generics/Holder1.java

/**
 * 15.2 简单泛型
 * 反面例子：这个类可重用性差，它无法持有其他类型的对象。
 * created at 2020-03-17 07:33
 * @author lerry
 */
public class Holder1 {
	private Automobile a;

	public Holder1(Automobile a) {
		this.a = a;
	}

	Automobile get() {
		return a;
	}
} ///:~

class Automobile {
}


