package holding.exercise;

import java.util.Iterator;
import java.util.Random;

import polymorphism.shape.*;

/**
 * 添加一个接受元素数量为参数的构造器，用迭代器生成指定数量的元素
 * Modify polymorphism/shape/RandomShapeGenerator.java
 * to make it Iterable. You’ll need to add a
 * constructor that takes the number of elements
 * Holding Your Objects
 * that you want the iterator to produce before
 * stopping. Verify that it works.
 */
class RandomShapeGenerator implements Iterable<Shape> {
	private Random rand = new Random(47);

	private final int quantity;

	RandomShapeGenerator(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public Iterator<Shape> iterator() {
		return new Iterator<Shape>() {
			private int count;

			@Override
			public boolean hasNext() {
				return count < quantity;
			}

			@Override
			public Shape next() {
				++count;
				return nextShape();
			}

			@Override
			public void remove() { // Not implemented
				throw new UnsupportedOperationException();
			}
		};
	}

	private Shape nextShape() {
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
}

public class E31_IterableRandomShapeGenerator {
	public static void main(String[] args) {
		RandomShapeGenerator rsg = new RandomShapeGenerator(10);
		for (Shape shape : rsg) {
			System.out.println(shape.getClass().getSimpleName());
		}
	}
} 