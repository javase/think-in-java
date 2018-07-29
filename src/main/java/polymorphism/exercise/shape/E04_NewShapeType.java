package polymorphism.exercise.shape;

import static net.mindview.util.Print.print;

/**
 * 对比E03，新加了一个形状，输出和前几个形状保持一致
 */
public class E04_NewShapeType {
	public static void main(String args[]) {
		Shape[] shapes = {
				new Circle(), new Square(), new Triangle(),
				new Tetrahedron()
		};
		// Make polymorphic method calls:
		for (Shape shape : shapes) {
			shape.draw();
			shape.erase();
			shape.msg();
			print("===========");
		}
	}
}