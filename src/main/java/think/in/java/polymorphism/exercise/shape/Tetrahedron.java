package think.in.java.polymorphism.exercise.shape;

import static net.mindview.util.Print.*;

/**
 * 四面体  新加的形状类型
 */
public class Tetrahedron extends Shape {
	@Override
	public void draw() {
		print("Tetrahedron.draw()");
	}

	@Override
	public void erase() {
		print("Tetrahedron.erase()");
	}

	@Override
	public void msg() {
		print("Tetrahedron.msg()");
	}
}