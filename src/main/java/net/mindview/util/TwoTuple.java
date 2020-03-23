//: net/mindview/util/TwoTuple.java
package net.mindview.util;

/**
 * 15.2.1 一个元祖类库
 * created at 2020-03-23 07:53
 * @author lerry
 */
public class TwoTuple<A, B> {
	public final A first;

	public final B second;

	public TwoTuple(A a, B b) {
		first = a; second = b;
	}

	@Override
	public String toString() {
		return "(" + first + ", " + second + ")";
	}
} ///:~
