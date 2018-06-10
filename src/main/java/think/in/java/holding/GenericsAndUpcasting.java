package think.in.java.holding;//: holding/GenericsAndUpcasting.java

import java.util.*;

/**
 * Apple类型的子类
 */
class GrannySmith extends Apple {
}

/**
 * Apple类型的子类
 */
class Gala extends Apple {
}

/**
 * Apple类型的子类
 */
class Fuji extends Apple {
}

/**
 * Apple类型的子类
 */
class Braeburn extends Apple {
}

public class GenericsAndUpcasting {
	public static void main(String[] args) {
		ArrayList<Apple> apples = new ArrayList<Apple>();
		apples.add(new GrannySmith());
		apples.add(new Gala());
		apples.add(new Fuji());
		apples.add(new Braeburn());
		// 向上转型
		for (Apple c : apples) {
			System.out.println(c);
		}
	}
} /* Output: (Sample)
GrannySmith@7d772e
Gala@11b86e7
Fuji@35ce36
Braeburn@757aef
*///:~
