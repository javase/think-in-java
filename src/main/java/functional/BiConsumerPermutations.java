package functional;// functional/BiConsumerPermutations.java
// (c)2017 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.function.BiConsumer;

/**
 * 第十三章 函数式编程 函数式接口
 * 缺少基本类型的函数
 * created at 2020-05-07 12:47
 * @author lerry
 */
public class BiConsumerPermutations {

	/**
	 * <pre>
	 *     这里使用 System.out.format() 来显示。
	 *     它类似于 System.out.println() 但提供了更多的显示选项。
	 *     这里，%f 表示我将 n 作为浮点值给出，
	 *     %d 表示 n 是一个整数值。
	 *     这其中可以包含空格，输入 %n 会换行 — 当然使用传统的 \n 也能换行，
	 *     但 %n 是自动跨平台的，这是使用 format() 的另一个原因。
	 * </pre>
	 */
	static BiConsumer<Integer, Double> bicid = (i, d) ->
			System.out.format("%d, %f%n", i, d);

	static BiConsumer<Double, Integer> bicdi = (d, i) ->
			System.out.format("%d, %f%n", i, d);

	static BiConsumer<Integer, Long> bicil = (i, l) ->
			System.out.format("%d, %d%n", i, l);

	/**
	 * 简单使用了包装类型，装箱和拆箱用于在基本类型之间来回转换
	 * @param args
	 */
	public static void main(String[] args) {
		bicid.accept(47, 11.34);
		bicdi.accept(22.45, 92);
		bicil.accept(1, 11L);
	}
}
/* Output:
47, 11.340000
92, 22.450000
1, 11
*/
