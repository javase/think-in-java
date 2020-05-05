package functional;// functional/RecursiveFibonacci.java
// (c)2017 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

/**
 * On Java 8读书笔记-第十三章 函数式编程
 * created at 2020-05-02 03:45
 * @author lerry
 */
public class RecursiveFibonacci {
	IntCall fib;

	RecursiveFibonacci() {
		fib =
				n -> n == 0
						? 0
						:
						n == 1
								? 1
								// 将 Fibonacci 序列中的最后两个元素求和来产生下一个元素
								: fib.call(n - 1) + fib.call(n - 2);
	}

	int fibonacci(int n) {
		return fib.call(n);
	}

	public static void main(String[] args) {
		RecursiveFibonacci rf = new RecursiveFibonacci();
		for (int i = 0; i <= 10; i++) {
			System.out.println(rf.fibonacci(i));
		}
	}
}
/* Output:
0
1
1
2
3
5
8
13
21
34
55
*/
