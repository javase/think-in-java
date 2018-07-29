package polymorphism.exercise.shape;

import static net.mindview.util.Print.*;

/**
 * 加上Override注解
 */
public class Square extends Shape {
	@Override
	public void draw() {
		print("Square.draw()");
	}

	@Override
	public void erase() {
		print("Square.erase()");
	}

	@Override
	public void msg() {
		print("Square.msg() method");
	}
}