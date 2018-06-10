package think.in.java.holding;//: holding/ApplesAndOrangesWithoutGenerics.java
// Simple container example (produces compiler warnings).
// {ThrowsException}

import java.util.*;

/**
 * 类型不对，强制转换时会报错：
 * java.lang.ClassCastException: think.in.java.holding.Orange cannot be cast to think.in.java.holding.Apple
 */
public class ApplesAndOrangesWithoutGenerics {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		ArrayList apples = new ArrayList();
		for (int i = 0; i < 3; i++) {
			apples.add(new Apple());
		}
		// Not prevented from adding an Orange to apples:
		apples.add(new Orange());
		for (int i = 0; i < apples.size(); i++) {
			((Apple) apples.get(i)).id();
		}
		// Orange is detected only at run time
	}
} /* (Execute to see output) *///:~
