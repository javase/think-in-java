package think.in.java.holding.exercise;

import java.util.*;

public class E02_SimpleCollection2 {
	public static void main(String[] args) {
		Collection<Integer> c = new HashSet<Integer>();
		for (int i = 0; i < 10; i++) {
			// Autoboxing
			c.add(i);
			// 会自动去重
			c.add(i);
		}
		for (Integer i : c) {
			System.out.print(i + ", ");
		}
	}
}