package think.in.java.innerclasses;//: innerclasses/Parcel7.java
// Returning an instance of an anonymous inner class.

import static net.mindview.util.Print.print;

public class Parcel7 {
	public Contents contents() {

		return new Contents() { // Insert a class definition
			private int i = 11;

			@Override
			public int value() {
				print("匿名内部类的方法");
				return i;
			}
		}; // Semicolon required in this case
	}

	public static void main(String[] args) {
		Parcel7 p = new Parcel7();
		Contents c = p.contents();
		c.value();
	}
} ///:~
