package typeinfo;//: typeinfo/Shapes.java

import static net.mindview.util.Print.*;

import java.util.Arrays;
import java.util.List;

/**
 * 基类
 * 包含draw()方法
 */
abstract class Shape {
	void draw() {
		System.out.println(this + ".draw()");
	}

	@Override
	abstract public String toString();
}

class Circle extends Shape {
	@Override
	public String toString() {
		return "Circle";
	}
}

class Square extends Shape {
	@Override
	public String toString() {
		return "Square";
	}
}

class Triangle extends Shape {
	@Override
	public String toString() {
		return "Triangle";
	}
}

public class Shapes {
	public static void main(String[] args) {
		// 当把派生类放入List时，发生了自动向上转型
		List<Shape> shapeList = Arrays.asList(
				new Circle(), new Square(), new Triangle()
		);
		for (Shape shape : shapeList) {
			printlnf("打印类型信息：%s", shape.getClass().getName());
			shape.draw();
		}
	}
} /* Output:
Circle.draw()
Square.draw()
Triangle.draw()
*///:~
