package generics;//: generics/Fibonacci.java
// Generate a Fibonacci sequence.

import net.mindview.util.Generator;

/**
 * 15.3 泛型接口
 * 负责生成Fibonacci数列
 * 基本类型无法作为类型参数，但是Java SE5可以自动拆装箱
 * created at 2020-03-24 08:45
 * @author lerry
 */
public class Fibonacci implements Generator<Integer> {
	private int count = 0;

	/**
	 * 使用了int类型的包装类型Integer
	 * @return
	 */
	@Override
	public Integer next() {
		return fib(count++);
	}

	private int fib(int n) {
		if (n < 2) {
			return 1;
		}
		return fib(n - 2) + fib(n - 1);
	}

	public static void main(String[] args) {
		Fibonacci gen = new Fibonacci();
		for (int i = 0; i < 18; i++) {
			System.out.print(gen.next() + " ");
		}
	}
} /* Output:
1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584
*///:~
