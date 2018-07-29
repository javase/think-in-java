package innerclasses;//: innerclasses/Parcel5.java
// Nesting a class within a method.

public class Parcel5 {

	// 方法里面的局部内部类
	public Destination destination(String s) {

		class PDestination implements Destination {
			private String label;

			private PDestination(String whereTo) {
				label = whereTo;
			}

			@Override
			public String readLabel() {
				return label;
			}
		}// end inner class
		return new PDestination(s);
	}

	// 和 destination() 方法里面的内部类名字并不冲突
	class PDestination implements Destination{
		@Override
		public String readLabel() {
			return null;
		}
	}
	public static void main(String[] args) {
		Parcel5 p = new Parcel5();
		Destination d = p.destination("Tasmania");
	}
} ///:~
