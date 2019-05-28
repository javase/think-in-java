package holding;//: holding/ModifyingArraysAsList.java

import java.util.*;

public class ModifyingArraysAsList {
	public static void main(String[] args) {
		Random rand = new Random(47);
		Integer[] ia = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		// 新创建了一个ArrayList，打乱不会修改原数组
		List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(ia));
		System.out.println("Before shuffling: " + list1);
		Collections.shuffle(list1, rand);
		System.out.println("After shuffling: " + list1);
		System.out.println("array: " + Arrays.toString(ia));

		// 没有新创建ArrayList，直接使用Arrays.asList(ia)的结果，会打乱原来ia数组的顺序
		List<Integer> list2 = Arrays.asList(ia);
		System.out.println("Before shuffling: " + list2);
		Collections.shuffle(list2, rand);
		System.out.println("After shuffling: " + list2);
		System.out.println("array: " + Arrays.toString(ia));
	}
} /* Output:
Before shuffling: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
After shuffling: [4, 6, 3, 1, 8, 7, 2, 5, 10, 9]
array: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Before shuffling: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
After shuffling: [9, 1, 6, 3, 7, 2, 5, 10, 4, 8]
array: [9, 1, 6, 3, 7, 2, 5, 10, 4, 8]
*///:~
