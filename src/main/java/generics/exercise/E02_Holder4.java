package generics.exercise;

/**
 * 练习2: (1) 创建一个Holder类，使其能够持有具有相同类型的3个对象，并提供相应的读写方法访问这些对象，
 * 以及一个可以初始化其持有的3个对象的构造器
 * created at 2020-03-17 07:59
 * @author lerry
 */
public class E02_Holder4 {
	public static void main(String[] args) {
		Holder4<String> h4 =
				new Holder4("A", "B", "C");
		System.out.println(h4.getA());
		System.out.println(h4.getB());
		System.out.println(h4.getC());
		h4.setC("D");
		System.out.println(h4.getC());
	}
} /* Output:
         A
         B
         C
         D
         *///:~

class Holder4<T> {
	private T a, b, c;

	/**
	 * 一个可以初始化其持有的3个对象的构造器
	 * @param a
	 * @param b
	 * @param c
	 */
	public Holder4(T a, T b, T c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public void setA(T a) {
		this.a = a;
	}

	public void setB(T b) {
		this.b = b;
	}

	public void setC(T c) {
		this.c = c;
	}

	public T getA() {
		return a;
	}

	public T getB() {
		return b;
	}

	public T getC() {
		return c;
	}
}
