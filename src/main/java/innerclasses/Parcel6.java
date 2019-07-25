package innerclasses;//: innerclasses/Parcel6.java
// Nesting a class within a scope.

import static net.mindview.util.Print.*;

public class Parcel6 {
	private void internalTracking(boolean b) {
		if (b) {

			class TrackingSlip {
				private String id;

				TrackingSlip(String s) {
					print("TrackingSlip类的构造方法被访问");
					id = s;
				}

				String getSlip() {
					return id;
				}
			} // end inner class

			TrackingSlip ts = new TrackingSlip("slip");
			String s = ts.getSlip();
		}
		// Can't use it here! Out of scope:
		//! TrackingSlip ts = new TrackingSlip("x");

	}

	public void track() {
		internalTracking(true);
	}

	public static void main(String[] args) {
		Parcel6 p = new Parcel6();
		p.track();
	}
} ///:~
