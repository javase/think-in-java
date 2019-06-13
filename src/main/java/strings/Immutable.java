package strings;//: strings/Immutable.java

import static net.mindview.util.Print.*;

public class Immutable {
	/**
	 * 传递的是引用的一个拷贝
	 * @param s  局部引用s，方法运行结束后，s就消失了。
	 * @return  返回的对象已经指向了一个新的对象，而原本的q则还在原地。
	 */
	public static String upcase(String s) {
		return s.toUpperCase();
	}

	public static void main(String[] args) {
		String q = "howdy";
		print(q); // howdy
		String qq = upcase(q);
		print(qq); // HOWDY
		print(q); // howdy
	}
} /* Output:
howdy
HOWDY
howdy
*///:~
