package generics.exercise;

/**
 * 15.2.2 一个堆栈类
 * 练习：证明内部类可以方位其外部类的类型参数
 * created at 2020-03-23 08:14
 * @author lerry
 */
public class E05_LinkedStack2 {
	public static void main(String[] args) {
		LinkedStack<String> lss = new LinkedStack<String>();
		for (String s : "Phasers on stun!".split(" ")) {
			lss.push(s);
		}
		String s;
		while ((s = lss.pop()) != null) {
			System.out.println(s);
		}
	}
} /* Output:
         stun!
         on
         Phasers
         *///:~


class LinkedStack<T> {

	private class Node {
		T item;

		Node next;

		Node() {
			item = null; next = null;
		}

		Node(T item, Node next) {
			this.item = item;
			this.next = next;
		}

		boolean end() {
			return item == null && next == null;
		}
	}

	// End sentinel
	private Node top = new Node();

	public void push(T item) {
		top = new Node(item, top);
	}

	public T pop() {
		T result = top.item;
		if (!top.end()) {
			top = top.next;
		}
		return result;
	}
}

