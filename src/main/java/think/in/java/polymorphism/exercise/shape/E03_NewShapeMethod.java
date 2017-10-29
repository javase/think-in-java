package think.in.java.polymorphism.exercise.shape;

import static net.mindview.util.Print.print;

/**
 * 当子类不覆盖父类的msg()方法时，调用的是父类的方法；
 * 如果覆盖，则调用子类的方法
 */
public class E03_NewShapeMethod {
	public static void main(String args[]) {
		Shape[] shapes = {
				new Circle(), new Square(), new Triangle(),
		};
		// Make polymorphic method calls:
		for (Shape shape : shapes) {
			shape.draw();
			shape.erase();
			shape.msg();
			print("----------");
		}
	}
}