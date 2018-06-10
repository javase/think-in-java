package think.in.java.holding;//: holding/ApplesAndOrangesWithGenerics.java

import java.util.*;

class Apple {
	private static long counter;

	private final long id = counter++;

	public long id() {
		return id;
	}
}


class Orange {

}

/**
 * 加上泛型的限制
 */
public class ApplesAndOrangesWithGenerics {
	public static void main(String[] args) {
		ArrayList<Apple> apples = new ArrayList<Apple>();
		for (int i = 0; i < 3; i++) {
			apples.add(new Apple());
		}
		// Compile-time error:
		// apples.add(new Orange());

		for (int i = 0; i < apples.size(); i++) {
			System.out.println(apples.get(i).id());
		}
		// Using foreach:
		for (Apple c : apples) {
			System.out.println(c.id());
		}
	}
} /* Output:
0
1
2
0
1
2
*///:~
