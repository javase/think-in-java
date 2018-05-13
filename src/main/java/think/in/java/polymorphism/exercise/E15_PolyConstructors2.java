package think.in.java.polymorphism.exercise;

import static net.mindview.util.Print.print;

/**
 * Created by limenghua on 2017/10/31.
 * @author limenghua
 */
class Glyph {
	void draw() {
		print("Glyph.draw()");
	}

	/**
	 * 在基类的构造器中，调用动态绑定的方法（此方法被导出类覆盖）
	 *
	 */
	Glyph() {
		print("Glyph() before draw()");
		draw();
		print("Glyph() after draw()");
	}
}

class RoundGlyph extends Glyph {
	private int radius = 1;

	RoundGlyph(int r) {
		radius = r;
		print("RoundGlyph.RoundGlyph(), radius = " + radius);
	}

	@Override
	void draw() {
		print("RoundGlyph.draw(), radius = " + radius);
	}
}

class RectangularGlyph extends Glyph {
	private int width = 4;

	private int height = 5;

	RectangularGlyph(int width, int height) {
		this.width = width;
		this.height = height;
		print("RectangularGlyph.RectangularGlyph(), width = " + width + ", height = " + height);
	}

	@Override
	void draw() {
		print("RectangularGlyph.draw(), area = " + width *
				height);
	}
}

/**
 * 在基类构造器中，调用动态绑定的方法，则导出类方法被调用时，导出类的成员实际上还未被初始化；
 * 当调用到导出类的构造器时，导出类的成员已经被初始化了；
 */
public class E15_PolyConstructors2 {
	public static void main(String[] args) {
		new RoundGlyph(5);
		print("------------------------------");
		new RectangularGlyph(2, 2);
	}
}
