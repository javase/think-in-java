package functional;// functional/RecursiveFactorial.java
// (c)2017 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

/**
 * On Java 8读书笔记-第十三章 函数式编程
 * 整数 n 的阶乘将所有小于或等于 n 的正整数相乘。 阶乘函数是一个常见的递归示例：
 * created at 2020-05-02 03:43
 * @author lerry
 */
public class RecursiveFactorial {
	/**
	 * fact 是一个静态变量
	 */
	static IntCall fact;

	public static void main(String[] args) {
		fact =
				n -> n == 0
						? 1
						: n * fact.call(n - 1);

		fact = new IntCallImpl();
		for (int i = 0; i <= 10; i++) {
			System.out.println(fact.call(i));
		}
	}
}

/**
 * 把递归写法展开，使用Java7的写法去实现
 */
class IntCallImpl implements IntCall {

	@Override
	public int call(int n) {
		if (n == 0) {
			return 1;
		}
		else {
			return n * call(n - 1);
		}

	}
}
/* Output:
1
1
2
6
24
120
720
5040
40320
362880
3628800
*/
