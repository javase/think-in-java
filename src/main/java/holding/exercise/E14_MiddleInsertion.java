package holding.exercise;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * 把数值插入到List的中间
 */
public class E14_MiddleInsertion {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();

		ListIterator<Integer> it = list.listIterator();

		for (int i = 1; i <= 10; i++) {
			it.add(i);
			if (i % 2 == 0) {
				System.out.print("it.previous();");
				it.previous();
			}
			System.out.println(list);
		}
	}
}