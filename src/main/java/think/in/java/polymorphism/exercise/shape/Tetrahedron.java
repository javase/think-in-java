package think.in.java.polymorphism.exercise.shape;

import static net.mindview.util.Print.*;

/**
 * 四面体  新加的形状类型
 */
public class Tetrahedron extends Shape {
	public void draw() {
		print("Tetrahedron.draw()");
	}

	public void erase() {
		print("Tetrahedron.erase()");
	}

	public void msg() {
		print("Tetrahedron.msg()");
	}
}