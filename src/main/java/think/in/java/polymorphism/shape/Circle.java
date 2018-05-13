//: polymorphism/shape/Circle.java
package think.in.java.polymorphism.shape;

import static net.mindview.util.Print.*;

public class Circle extends Shape {
	@Override
	public void draw() {
		print("Circle.draw()");
	}

	@Override
	public void erase() {
		print("Circle.erase()");
	}
} ///:~
