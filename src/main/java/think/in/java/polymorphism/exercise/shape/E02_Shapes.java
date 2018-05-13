package think.in.java.polymorphism.exercise.shape;

public class E02_Shapes {
	private static RandomShapeGenerator gen =
			new RandomShapeGenerator();

	public static void main(String[] args) {
		Shape[] shapes = new Shape[9];
		// Fill up the array with shapes:
		for (int i = 0; i < shapes.length; i++) {
			shapes[i] = gen.next();
		}
		// Make polymorphic method calls:
		for (Shape shape : shapes) {
			shape.draw();
		}
	}
}