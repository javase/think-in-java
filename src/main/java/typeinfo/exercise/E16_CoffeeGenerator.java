package typeinfo.exercise;

import java.util.Iterator;

import net.mindview.util.Generator;
import typeinfo.coffee2.Coffee;

/**
 * 修改第15章中的Coffee继承结构，以便可以使用注册工厂。
 * created at 2019-08-22 17:32
 * @author lerry
 */
public class E16_CoffeeGenerator  implements Generator<Coffee>, Iterable<Coffee> {
	public E16_CoffeeGenerator() {
	}

	private int size = 0;

	public E16_CoffeeGenerator(int sz) {
		size = sz;
	}

	@Override
	public Coffee next() {
		return Coffee.createRandom();
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
			return E16_CoffeeGenerator.this.next();
		}

		@Override
		public void remove() {
		} // Not implemented
	}

	;

	@Override
	public Iterator<Coffee> iterator() {
		return new CoffeeIterator();
	}

	public static void main(String[] args) {
		for (Coffee c : new E16_CoffeeGenerator(10)) {
			System.out.println(c);
		}
	}
}