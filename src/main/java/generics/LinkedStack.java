package generics;//: generics/LinkedStack.java
// A stack implemented with an internal linked structure.

/**
 * 15.2.2 一个堆栈类
 * 不用LinkedList，来实现自己的内部链式存储机制
 * created at 2020-03-23 08:09
 * @author lerry
 */
public class LinkedStack<T> {

	/**
	 * 内部类Node，也是一个泛型，拥有自己的类型参数
	 * created at 2020-03-23 08:10
	 * @author lerry
	 */
	private static class Node<U> {
		U item;

		Node<U> next;

		Node() {
			item = null; next = null;
		}

		Node(U item, Node<U> next) {
			this.item = item;
			this.next = next;
		}

		boolean end() {
			return item == null && next == null;
		}

	}
	// End sentinel

	/**
	 * 用来判断堆栈何时为空
	 */
	private Node<T> top = new Node<T>();

	public void push(T item) {
		top = new Node<T>(item, top);
	}

	public T pop() {
		T result = top.item;
		if (!top.end()) {
			top = top.next;
		}
		return result;
	}

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
