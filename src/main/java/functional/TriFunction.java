package functional;// functional/TriFunction.java
// (c)2017 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

/**
 * 第十三章 函数式编程 函数式接口
 * 多参数函数式接口
 * created at 2020-05-07 12:43
 * @author lerry
 */
@FunctionalInterface
public interface TriFunction<T, U, V, R> {

	/**
	 * 三参数函数的接口
	 * @param t
	 * @param u
	 * @param v
	 * @return
	 */
	R apply(T t, U u, V v);
}
