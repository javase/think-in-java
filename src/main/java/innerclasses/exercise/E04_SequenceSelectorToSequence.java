package innerclasses.exercise;


/**
 * 迭代器接口
 */
interface Selector {
	boolean end();

	Object current();

	void next();
}

class Sequence2 {
	private Object[] items;

	private int next;

	public Sequence2(int size) {
		items = new Object[size];
	}

	public void add(Object x) {
		if (next < items.length) {
			items[next++] = x;
		}
	}

	private class SequenceSelector implements Selector {
		private int i;

		@Override
		public boolean end() {
			return i == items.length;
		}

		@Override
		public Object current() {
			return items[i];
		}

		@Override
		public void next() {
			if (i < items.length) {
				i++;
			}
		}

		/**
		 * 在内部类中，返回外部类的实例引用
		 * @return
		 */
		public Sequence2 sequence() {
			return Sequence2.this;
		}
	}

	public Selector selector() {
		return new SequenceSelector();
	}

	public boolean check() {
		// 获取内部类对象实例
		SequenceSelector sequenceSelector = (SequenceSelector) selector();
		// 通过内部类提供的  获取当前外部类实例引用的方法，来获取外部类实例
		Sequence2 sequence2 = sequenceSelector.sequence();
		return
				this == sequence2;
	}
}

public class E04_SequenceSelectorToSequence {
	public static void main(String[] args) {
		Sequence2 s = new Sequence2(10);
		System.out.println(String.format("比较两个外部类的引用是否一致：%s", s.check()));
	}
}