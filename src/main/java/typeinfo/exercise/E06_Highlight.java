package typeinfo.exercise;

import static net.mindview.util.Print.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 这个程序能将某个特定类型的所有形状都"标示"出来。
 * 每一个导出的 Shape 类的toString() 方法应该更能够指出Shape是否被标示
 * created at 2019-08-09 12:37
 * @author lerry
 */
public class E06_Highlight {
	static int i = 0;

	public static void main(String[] args) {

		List<HShape> shapes = Arrays.asList(
				new HCircle(), new HSquare(),
				new HTriangle(), new HSquare(),
				new HTriangle(), new HCircle(),
				new HCircle(), new HSquare());
		printlnf("shapes中有%d个Circle，%d个Square，%d个Triangle", 3, 3, 2);

		HShape.highlight1(HCircle.class);
		HShape.highlight2(HCircle.class);
		for (HShape shape : shapes) {
			print(++i + ":");
			shape.draw();
		}


		printALine();
		printlnf("将所有形状都设置为高亮");
		// Highlight them all:
		HShape.highlight1(HShape.class);
		HShape.highlight2(HShape.class);
		i = 0;
		for (HShape shape : shapes) {
			print(++i + ":");
			shape.draw();
		}
		printALine();
		printlnf("消除不在一个继承体系下的ArrayList类型的高亮");
		// Not in the hierarchy:
		HShape.clearHighlight1(ArrayList.class);
		HShape.clearHighlight2(ArrayList.class);
		i = 0;
		for (HShape shape : shapes) {
			print(++i + ":");
			shape.draw();
		}
	}
}

class HShape {

	boolean highlighted = false;

	public void highlight() {
		highlighted = true;
	}

	public void clearHighlight() {
		highlighted = false;
	}

	void draw() {
		System.out.println(this + " draw()");
	}

	@Override
	public String toString() {
		return getClass().getName() +
				(highlighted ? " highlighted" : " normal");
	}

	static List<HShape> shapes = new ArrayList<>();

	HShape() {
		shapes.add(this);
	}

	// Basic approach (code duplication)

	/**
	 * 指定类型的被高亮
	 * @param type
	 */
	static void highlight1(Class<?> type) {
		for (HShape shape : shapes) {
			if (type.isInstance(shape)) {
				shape.highlight();
			}
		}
	}

	/**
	 * 指定类型的被取消高亮
	 * @param type
	 */
	static void clearHighlight1(Class<?> type) {
		for (HShape shape : shapes) {
			if (type.isInstance(shape)) {
				shape.clearHighlight();
			}
		}
	}

	// Create an applicator and reuse it. All exceptions
	// indicate programmer error, and are thus
	// RuntimeExceptions:

	/**
	 * 我们可以在forEach()中使用反射来组合列表迭代期间出现在Highlight1()和clearHighlight1()中的冗余代码
	 * @param type
	 * @param method
	 */
	static void forEach(Class<?> type, String method) {
		try {
			Method m = HShape.class.getMethod(method, (Class<?>[]) null);
			for (HShape shape : shapes) {
				if (type.isInstance(shape)) {
					m.invoke(shape, (Object[]) null);
				}
			}
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	static void highlight2(Class<?> type) {
		forEach(type, "highlight");
	}

	static void clearHighlight2(Class<?> type) {
		forEach(type, "clearHighlight");
	}
}

class HCircle extends HShape {
}

class HSquare extends HShape {
}

class HTriangle extends HShape {
}