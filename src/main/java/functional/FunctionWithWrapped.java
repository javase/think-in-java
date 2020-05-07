package functional;// functional/FunctionWithWrapped.java
// (c)2017 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.function.Function;
import java.util.function.IntToDoubleFunction;

/**
 * 第十三章 函数式编程 函数式接口
 * 缺少基本类型的函数
 * created at 2020-05-07 12:51
 * @author lerry
 */
public class FunctionWithWrapped {
	public static void main(String[] args) {

		// 使用基本类型可以防止传递参数和返回结果过程中的自动装箱和自动拆箱。
		Function<Integer, Double> fid = i -> (double) i;

		// 如果没有强制转换，则会收到错误消息：“Integer cannot be converted to Double”（Integer 无法转换为 Double）
		// Function<Integer,Double> function =integer -> integer;
		IntToDoubleFunction fid2 = i -> i;
	}
}
