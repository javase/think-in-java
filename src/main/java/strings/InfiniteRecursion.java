package strings;//: strings/InfiniteRecursion.java
// Accidental recursion.
// {RunByHand}

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 无限递归
 * 编译器看到一个String对象后面跟着一个"+"，而再后面的对象不是String，于是编译器试着将this转换成一个String。
 * 它怎么转换呢？正是通过调用this上的toString()方法，于是就发生了递归调用
 * </pre>
 */
public class InfiniteRecursion {
	@Override
	public String toString() {
		return " InfiniteRecursion address: " + this + "\n";
	}

	public static void main(String[] args) {
		List<InfiniteRecursion> v = new ArrayList<InfiniteRecursion>();
		for (int i = 0; i < 10; i++) {
			v.add(new InfiniteRecursion());
		}
		System.out.println(v);
	}
} ///:~
