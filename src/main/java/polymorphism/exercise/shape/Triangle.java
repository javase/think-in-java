package polymorphism.exercise.shape;

import static net.mindview.util.Print.*;

public class Triangle extends Shape {
	@Override
	public void draw() {
		print("Triangle.draw()");
	}

	@Override
	public void erase() {
		print("Triangle.erase()");
	}

	@Override
	public void msg() {
		print("Triangle.msg() method");
	}
}