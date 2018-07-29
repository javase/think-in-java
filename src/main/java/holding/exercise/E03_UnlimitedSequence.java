package holding.exercise;

import java.util.*;


/**
 * 迭代器接口
 */
interface Selector {
	boolean end();

	Object current();

	void next();
}


class UnlimitedSequence {
	// 使用List充当容器
	private final List<Object> items =
			new ArrayList<Object>();

	public void add(Object x) {
		items.add(x);
	}

	private class SequenceSelector implements Selector {
		private int i;

		@Override
		public boolean end() {
			boolean ifEnd = i == items.size();
			return ifEnd;
		}

		@Override
		public Object current() {
			Object object = items.get(i);
			return object;
		}

		@Override
		public void next() {
			if (i < items.size()) {
				i++;
			}
		}
	}

	public Selector selector() {
		return new SequenceSelector();
	}
}

public class E03_UnlimitedSequence {

	public static void main(String[] args) {
		int size = 15;
		UnlimitedSequence sequence = new UnlimitedSequence();
		for (int i = 0; i < size; i++) {
			sequence.add(String.format("第%d个元素", i + 1));
		}
		Selector selector = sequence.selector();
		while (!selector.end()) {
			System.out.println((String.format("当前对象是：%s", selector.current())));
			selector.next();
		}
	}
}