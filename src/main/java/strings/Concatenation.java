package strings;//: strings/Concatenation.java

/**
 * 查看字节码，会发现编译器使用了 StringBuilder 类
 */
public class Concatenation {
	public static void main(String[] args) {
		String mango = "mango";
		String s = "abc" + mango + "def" + 47;
		System.out.println(s);
	}
} /* Output:
abcmangodef47
*///:~
