package holding;//: holding/ArrayIsNotIterable.java

import java.util.*;

import net.mindview.util.Print;

/**
 * 数组不是一个Iterable类型
 */
public class ArrayIsNotIterable {

	static <T> void test(Iterable<T> ib) {
		for (T t : ib) {
			System.out.print(t + " ");
		}
	}

	public static void main(String[] args) {
		test(Arrays.asList(1, 2, 3));
		String[] strings = {"A", "B", "C"};
		// An array works in foreach, but it's not Iterable:
		//! test(strings);
		// You must explicitly convert it to an Iterable:
		test(Arrays.asList(strings));

		Print.printlnf("\n数组的类型是：%s",strings.getClass().getName());
		Print.printlnf("数组的类型是：%s",strings.getClass().getSimpleName());
	}
} /* Output:
1 2 3 A B C
*///:~
