package generics;//: generics/Holder3.java

/**
 * <pre>
 * 15.2 简单泛型
 * "Holder3"类名后面中的尖括号包裹的T就是类型参数
 * 这样子，当你创建Holder3对象时，必须指明想持有什么类型的参数
 * </pre>
 * created at 2020-03-17 07:45
 * @author lerry
 */
public class Holder3<T> {
	private T a;

	public Holder3() {
	}

	public Holder3(T a) {
		this.a = a;
	}

	public void set(T a) {
		this.a = a;
	}

	public T get() {
		return a;
	}

	public static void main(String[] args) {
		Holder3<Automobile> h3 =
				new Holder3(new Automobile());
		Automobile a = h3.get(); // No cast needed
		// h3.set("Not an Automobile"); // Error
		// h3.set(1); // Error
	}
} ///:~
