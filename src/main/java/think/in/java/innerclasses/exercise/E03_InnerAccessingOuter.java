package think.in.java.innerclasses.exercise;

/**
 * 内部类拥有其外围类的所有元素的访问权
 */
class Outer2 {
	private final String data;

	/**
	 * 内部类的toString方法可以返回外部类的data属性
	 */
	class Inner {
		public String toString() {
			return data;
		}
	}

	Outer2(String data) {
		this.data = data;
	}

	Inner getInner() {
		return new Inner();
	}
}

public class E03_InnerAccessingOuter {
	public static void main(String[] args) {
		Outer2 o = new Outer2("Inner accessing outer!");
		Outer2.Inner i = o.getInner();
		System.out.println(i);
	}
}