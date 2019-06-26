package strings.exercise.hua;//: strings/InfiniteRecursion.java
// Accidental recursion.
// {RunByHand}

import net.mindview.util.Print;

/**
 * <pre>
 * 无限递归
 * 编译器看到一个String对象后面跟着一个"+"，而再后面的对象不是String，于是编译器试着将this转换成一个String。它怎么
 * 转换呢？正是通过调用this上的toString()方法，于是就发生了递归调用
 * 修复该程序，使用super.toString()方法。 就是调用Object根类的toString()方法。
 * </pre>
 */
public class InfiniteRecursion02 {
	@Override
	public String toString() {
		return " InfiniteRecursion address: " + super.toString() + "\n";
	}

	public static void main(String[] args) {
		Print.printlnf(new InfiniteRecursion02().toString());
	}
} ///:~
