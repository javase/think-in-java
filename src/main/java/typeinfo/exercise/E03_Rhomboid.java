package typeinfo.exercise;

import static net.mindview.util.Print.*;

import java.util.Arrays;
import java.util.List;

import polymorphism.shape.Circle;
import polymorphism.shape.Shape;
import polymorphism.shape.Square;
import polymorphism.shape.Triangle;

class Rhomboid extends Shape {
	@Override
	public String toString() {
		return "Rhomboid";
	}

	@Override
	public void draw() {
		print("Rhomboid.draw()");
	}
}

public class E03_Rhomboid {
	public static void main(String[] args) {
		List<Shape> shapes = Arrays.asList(
				new Circle(), new Square(), new Triangle(),
				new Rhomboid()
		);
		for (Shape shape : shapes) {
			shape.draw();
		}
		// Upcast to shape:
		Shape shape = new Rhomboid();
		// Downcast to Rhomboid:
		Rhomboid r = (Rhomboid) shape;
		// Downcast to Circle. Succeeds at compile time,
		// but fails at runtime with a ClassCastException:
//		! Circle c = (Circle)shape;

	}
}