package generics;//: generics/Holder2.java

/**
 * 15.2 简单泛型
 * 直接持有Object类型的属性，Holder2就可以存储任何类型的对象
 * created at 2020-03-17 07:38
 * @author lerry
 */
public class Holder2 {
	private Object a;

	public Holder2(Object a) {
		this.a = a;
	}

	public void set(Object a) {
		this.a = a;
	}

	public Object get() {
		return a;
	}

	public static void main(String[] args) {
		Holder2 h2 = new Holder2(new Automobile());
		Automobile a = (Automobile) h2.get();
		h2.set("Not an Automobile");

		String s = (String) h2.get();
		h2.set(1); // Autoboxes to Integer
		Integer x = (Integer) h2.get();
	}
} ///:~
