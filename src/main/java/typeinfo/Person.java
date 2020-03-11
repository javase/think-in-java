package typeinfo;//: typeinfo/Person.java
// A class with a Null Object.

import net.mindview.util.Null;

/**
 * 14.8 空对象：
 * 该实体类，包含了一个单例的、表示"空"对象 的属性
 * created at 2020-03-11 07:08
 * @author lerry
 */
class Person {
	public final String first;

	public final String last;

	public final String address;

	// etc.
	public Person(String first, String last, String address) {
		this.first = first;
		this.last = last;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person: " + first + " " + last + " " + address;
	}

	/**
	 * 实现了"空"接口标记的类
	 * created at 2020-03-11 07:09
	 * @author lerry
	 */
	public static class NullPerson extends Person implements Null {
		private NullPerson() {
			super("None", "None", "None");
		}

		@Override
		public String toString() {
			return "NullPerson";
		}
	}

	public static final Person NULL = new NullPerson();
} ///:~
