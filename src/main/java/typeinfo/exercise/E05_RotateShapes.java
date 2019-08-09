package typeinfo.exercise;

import java.util.Arrays;
import java.util.List;

/**
 * 这个程序使用rotateAll()而不是rotate(Shape)执行所需的检查
 * created at 2019-08-09 12:29
 * @author lerry
 */
public class E05_RotateShapes {
	static void rotateAll(List<RShape> shapes) {
		for (RShape shape : shapes) {
			// 不是圆形，就旋转45°
			if (!(shape instanceof RCircle)) {
				shape.rotate(45);
			}
		}
	}

	public static void main(String[] args) {
		List<RShape> shapes = Arrays.asList(
				new RCircle(), new RSquare(), new RTriangle()
		);
		rotateAll(shapes);
	}
}/* Output:
         Rotating Square by 45 degrees
         Rotating Triangle by 45 degrees
         *///:~

abstract class RShape {
	void draw() {
		System.out.println(this + ".draw()");
	}

	@Override
	abstract public String toString();

	/**
	 * 旋转
	 * @param degrees 角度
	 */
	void rotate(int degrees) {
		System.out.println("Rotating " + this +
				" by " + degrees + " degrees");
	}
}

class RCircle extends RShape {
	@Override
	public String toString() {
		return "Circle";
	}

	@Override
	void rotate(int degrees) {
		throw new UnsupportedOperationException();
	}
}

/**
 * Square 正方形
 */
class RSquare extends RShape {
	@Override
	public String toString() {
		return "Square";
	}
}

class RTriangle extends RShape {
	@Override
	public String toString() {
		return "Triangle";
	}
}
