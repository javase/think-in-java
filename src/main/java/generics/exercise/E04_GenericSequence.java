package generics.exercise;

/**
 *
 * 泛型化：innerclasses.Sequence
 * created at 2020-03-23 08:07
 * @author lerry
 */
public class E04_GenericSequence {
	public static void main(String[] args) {
		Sequence<String> sequence = new Sequence<String>(10);
		for (int i = 0; i < 10; i++) {
			sequence.add(Integer.toString(i));
		}
		Selector<String> selector = sequence.selector();
		while (!selector.end()) {
			System.out.print(selector.current() + " ");
			selector.next();
		}
	}
} /* Output: 0123456789 *///:~

interface Selector<T> {
	boolean end();

	T current();

	void next();
}
/**
 * 使用T，来表示确定的一种类型
 * created at 2020-03-23 08:08
 * @author lerry
 */
class Sequence<T> {
	private Object[] items;

	private int next;

	public Sequence(int size) {
		items = new Object[size];
	}

	public void add(T x) {
		if (next < items.length) {
			items[next++] = x;
		}
	}

	private class SequenceSelector implements Selector<T> {
		private int i;

		@Override
		public boolean end() {
			return i == items.length;
		}

		@Override
		@SuppressWarnings("unchecked")
		public T current() {
			return (T) items[i];
		}

		@Override
		public void next() {
			if (i < items.length) {
				i++;
			}
		}
	}

	public Selector<T> selector() {
		return new SequenceSelector();
	}
}

