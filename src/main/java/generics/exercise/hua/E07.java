package generics.exercise.hua;

import static net.mindview.util.Print.*;

import java.util.Iterator;

import generics.Fibonacci;

/**
 * 使用组合代替继承，适配Fibonacci使其成为Iterable
 * created at 2020-03-24 08:57
 * @author lerry
 */
public class E07 implements Iterable<Integer> {

	private int n;

	private Fibonacci fibonacci = new Fibonacci();

	public E07(int count) {
		this.n = count;
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
				n--;
				return fibonacci.next();
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	public static void main(String[] args) {
		E07 e07 = new E07(18);
		for (Integer integer : e07) {
			printlnf("%s\t", integer);
		}
	}
}
