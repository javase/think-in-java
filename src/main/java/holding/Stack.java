package holding;

import java.util.LinkedList;

/**
 * created at 2018-06-25 07:15
 * @author limenghua
 */
public class Stack<T> {
	private LinkedList<T> storage = new LinkedList<T>();

	public void push(T v) {
		storage.addFirst(v);
	}

	public T peek() {
		return storage.getFirst();
	}

	public T pop() {
		return storage.removeFirst();
	}

	public boolean empty() {
		return storage.isEmpty();
	}

	@Override
	public String toString() {
		return "Stack{" +
				"storage=" + storage +
				'}';
	}
}
