package think.in.java.polymorphism;//: polymorphism/Shapes.java
// Polymorphism in Java.


import think.in.java.polymorphism.shape.RandomShapeGenerator;
import think.in.java.polymorphism.shape.Shape;

public class Shapes {
	private static RandomShapeGenerator gen =
			new RandomShapeGenerator();

	public static void main(String[] args) {
		Shape[] s = new Shape[9];
		// Fill up the array with shapes:
		// 随机产生9组Shape对象
		for (int i = 0; i < s.length; i++) {
			s[i] = gen.next();
		}
		// Make polymorphic method calls:
		for (Shape shp : s) {
			shp.draw();
		}
	}
} /* Output:
Triangle.draw()
Triangle.draw()
Square.draw()
Triangle.draw()
Square.draw()
Triangle.draw()
Square.draw()
Triangle.draw()
Circle.draw()
*///:~
