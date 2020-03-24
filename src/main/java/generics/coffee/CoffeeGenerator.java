//: generics/coffee/CoffeeGenerator.java
// Generate different types of Coffee:
package generics.coffee;

import java.util.Iterator;
import java.util.Random;

import net.mindview.util.Generator;

/**
 * 15.3 泛型接口
 * 可以随机生成不同类型的咖啡对象
 * 实现了Iterable接口，可以在循环语句中使用
 * created at 2020-03-24 08:41
 * @author lerry
 */
public class CoffeeGenerator
		implements Generator<Coffee>, Iterable<Coffee> {


	public static void main(String[] args) {
		CoffeeGenerator gen = new CoffeeGenerator();
		for (int i = 0; i < 5; i++) {
			System.out.println(gen.next());
		}
		for (Coffee c : new CoffeeGenerator(5)) {
			System.out.println(c);
		}
	}

	private Class[] types = {Latte.class, Mocha.class,
			Cappuccino.class, Americano.class, Breve.class,};

	private static Random rand = new Random(47);

	public CoffeeGenerator() {
	}

	// For iteration:
	private int size = 0;

	public CoffeeGenerator(int sz) {
		size = sz;
	}

	@Override
	public Coffee next() {
		try {
			return (Coffee)
					types[rand.nextInt(types.length)].newInstance();
			// Report programmer errors at run time:
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	class CoffeeIterator implements Iterator<Coffee> {
		int count = size;

		@Override
		public boolean hasNext() {
			return count > 0;
		}

		@Override
		public Coffee next() {
			count--;
			return CoffeeGenerator.this.next();
		}

		@Override
		public void remove() { // Not implemented
			throw new UnsupportedOperationException();
		}
	}

	;

	@Override
	public Iterator<Coffee> iterator() {
		return new CoffeeIterator();
	}

} /* Output:
Americano 0
Latte 1
Americano 2
Mocha 3
Mocha 4
Breve 5
Americano 6
Latte 7
Cappuccino 8
Cappuccino 9
*///:~
