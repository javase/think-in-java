package think.in.java.innerclasses.exercise;

class Sequence3 {
	private Object[] objects;

	private int next;

	public Sequence3(int size) {
		objects = new Object[size];
	}

	public void add(Object x) {
		if (next < objects.length) {
			objects[next++] = x;
		}
	}

	/**
	 * 反方向遍历序列
	 */
	private class ReverseSelector implements Selector {
		int i = objects.length - 1;

		@Override
		public boolean end() {
			return i < 0;
		}

		@Override
		public Object current() {
			return objects[i];
		}

		@Override
		public void next() {
			if (i >= 0) {
				i--;
			}
		}
	}

	/**
	 * 正序遍历序列
	 */	private class SequenceSelector implements Selector {
		private int i = 0;

		@Override
		public boolean end() {
			return i == objects.length;
		}

		@Override
		public Object current() {
			return objects[i];
		}

		@Override
		public void next() {
			if (i < objects.length) {
				i++;
			}
		}
	}

	public Selector selector() {
		return new SequenceSelector();
	}

	public Selector reverseSelector() {
		return new ReverseSelector();
	}
}

public class E22_GetRSelector {
	public static void main(String[] args) {
		Sequence3 sequence = new Sequence3(10);
		for (int i = 0; i < 10; i++) {
			sequence.add(Integer.toString(i));
		}
		// 反向
		Selector reverseSelector = sequence.reverseSelector();
		while (!reverseSelector.end()) {
			System.out.print(reverseSelector.current() + " ");
			reverseSelector.next();
		}

		System.out.println();

		// 正向
		Selector selector = sequence.selector();
		while (!selector.end()) {
			System.out.print(selector.current() + " ");
			selector.next();
		}
	}
} /* Output: 9876543210 *///:~