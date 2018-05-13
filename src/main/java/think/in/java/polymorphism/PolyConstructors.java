package think.in.java.polymorphism;//: polymorphism/PolyConstructors.java
// Constructors and polymorphism
// don't produce what you might expect.

import static net.mindview.util.Print.*;

class Glyph {
	void draw() {
		print("Glyph.draw()");
	}

	/**
	 * 在父类的构造器中，调用动态绑定的方法
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

/**
 * 先父类构造器；
 * 后域；
 * 再子类构造器；
 */
public class PolyConstructors {
	public static void main(String[] args) {
		new RoundGlyph(5);
	}
} /* Output:
Glyph() before draw()
RoundGlyph.draw(), radius = 0
Glyph() after draw()
RoundGlyph.RoundGlyph(), radius = 5
*///:~
