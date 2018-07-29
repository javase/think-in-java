package innerclasses;//: innerclasses/Parcel2.java
// Returning a reference to an inner class.

public class Parcel2 {
	class Contents {
		private int i = 11;

		public int value() {
			return i;
		}
	}

	class Destination {
		private String label;

		Destination(String whereTo) {
			label = whereTo;
		}

		String readLabel() {
			return label;
		}
	}

	/**
	 * 外部类的方法指向内部类的引用
	 * @param s
	 * @return
	 */
	public Destination to(String s) {
		return new Destination(s);
	}

	public Contents contents() {
		return new Contents();
	}

	public void ship(String dest) {
		Contents c = contents();
		Destination d = to(dest);
		System.out.println(d.readLabel());
	}

	public static void main(String[] args) {
		Parcel2 p = new Parcel2();
		p.ship("Tasmania");
		Parcel2 q = new Parcel2();
		// Defining references to inner classes:
		Contents c = q.contents();

		Destination d = q.to("Borneo");
		// 创建内部类对象的写法
		Parcel2.Destination d2 = q.to("Borneo");
	}
} /* Output:
Tasmania
*///:~
