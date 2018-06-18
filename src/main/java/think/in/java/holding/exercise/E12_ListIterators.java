package think.in.java.holding.exercise;


import static net.mindview.util.Print.print;

import java.util.*;

public class E12_ListIterators {

	static void reverse(List<Integer> list) {
		ListIterator<Integer> fwd = list.listIterator();
		ListIterator<Integer> rev = list.listIterator(list.size());
		// 右移运算符，num >> 1,相当于num除以2
		int mid = list.size() >> 1;
		print(String.format("mid:%s", mid));

		for (int i = 0; i < mid; i++) {
			// 向后获取元素
			Integer tmp = fwd.next();
			print(String.format("fwd.next():%d", tmp));

			// 向前获取元素
			int previous = rev.previous();
			print(String.format("rev.previous():%d", previous));
			fwd.set(previous);
			rev.set(tmp);
		}
	}

	public static void main(String[] args) {
		List<Integer> src =
				Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);

		List<Integer> dest = new LinkedList<Integer>(src);

		System.out.println("source: " + src);
		System.out.println("destination: " + dest);

		reverse(dest);
		System.out.println("source: " + src);
		System.out.println("destination: " + dest);
	}
}