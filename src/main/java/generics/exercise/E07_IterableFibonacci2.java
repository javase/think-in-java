package generics.exercise;

import java.util.Iterator;

import generics.Fibonacci;

/**
 * 15.3 泛型接口
 * 使用组合代替继承，适配 Fibonacci 使其成为Iterable
 * created at 2020-04-03 12:33
 * @author lerry
 */
public class E07_IterableFibonacci2 {

	public static void main(String[] args) {
		for (int i : new IterableFibonacci(18)) {
			System.out.print(i + " ");
		}
	}
}
/* Output:
         1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584
         *///:~

class IterableFibonacci implements Iterable<Integer> {

	private Fibonacci fib = new Fibonacci();

	private int n;

	public IterableFibonacci(int count) {
		n = count;
	}

	@Override
	public Iterator<Integer> iterator() {

		return new Iterator<Integer>() {
			@Override
			public boolean hasNext() {
				return n > 0;
			}

			@Override
			public Integer next() {
				--n;
				return fib.next();
			}

			@Override
			public void remove() { // Not implemented
				throw new UnsupportedOperationException();
			}
		};
	}// end method

}

