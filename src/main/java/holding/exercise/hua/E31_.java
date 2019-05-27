package holding.exercise.hua;

import java.util.Iterator;
import java.util.Random;

import net.mindview.util.Print;
import polymorphism.exercise.shape.*;

/**
 * created at 2019-05-28 07:01
 * @author lerry
 */
public class E31_ implements Iterable<Shape> {

	private Random rand = new Random(47);

	private Integer count;

	private Integer index;

	public E31_(Integer count) {
		this.count = count;
		this.index = count;
	}

	@Override
	public Iterator<Shape> iterator() {

		return new Iterator<Shape>() {
			@Override
			public boolean hasNext() {
				return index > 0;
			}

			@Override
			public Shape next() {
				index--;
				switch (rand.nextInt(3)) {
					default:
					case 0:
						return new Circle();
					case 1:
						return new Square();
					case 2:
						return new Triangle();
				}

			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	public static void main(String[] args) {
		for (Shape arg : new E31_(5)) {
			Print.printlnf(arg.toString());
		}
	}
}
