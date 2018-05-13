package think.in.java.innerclasses;


/**
 * 迭代器接口
 */
interface Selector {
	boolean end();

	Object current();

	void next();
}

public class Sequence {
	private Object[] items; // 内部持有一个Object数组

	private int next = 0;

	/**
	 * 初始化Object数组
	 * @param size
	 */
	public Sequence(int size) {
		items = new Object[size];
	}

	public void add(Object item) {
		if (next < items.length) {
			items[next++] = item;
		}
	}

	public Selector getSelector() {
		return new SequenceSelector();
	}

	/**
	 * 实现了迭代器接口的内部类
	 */
	private class SequenceSelector implements Selector {

		private int i = 0;

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

	}// end inner class


	public static void main(String[] args) {
		Sequence sequence = new Sequence(10);

		for (int i = 0; i < 10; i++) {
			sequence.add(String.format("我是第%d个元素", i + 1));
		}
		Selector selector = sequence.getSelector();
		while (!selector.end()) {
			System.out.println((String.format("当前对象是：%s", selector.current())));
			selector.next();
		}
	}// end main method
}

/**
 * 练习题
 */
class StringHolder {
	private String data;

	StringHolder(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return data;
	}
}

