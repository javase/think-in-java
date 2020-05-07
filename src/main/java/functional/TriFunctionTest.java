package functional;// functional/TriFunctionTest.java
// (c)2017 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import static net.mindview.util.Print.*;

/**
 * 第十三章 函数式编程 函数式接口
 * 多参数函数式接口
 * created at 2020-05-07 12:44
 * @author lerry
 */
public class TriFunctionTest {

	/**
	 * 与 TriFunction接口的方法 R apply(T t, U u, V v);
	 * 拥有相同的方法签名
	 * @param i
	 * @param l
	 * @param d
	 * @return
	 */
	static int f(int i, long l, double d) {
		return 99;
	}

	public static void main(String[] args) {
		TriFunction<Integer, Long, Double, Integer> tf = TriFunctionTest::f;
		tf = (i, l, d) -> 12;
		printlnf("result is %s", tf.getClass().getName());
	}
}
