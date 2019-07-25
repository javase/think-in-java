package strings;//: strings/SplitDemo.java

import static net.mindview.util.Print.*;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * <pre>
 * 演示了 split()方法的使用
 * public String[] split(CharSequence input, int limit) {...} 限制了将输入分隔成字符串的数量
 * </pre>
 */
public class SplitDemo {
	public static void main(String[] args) {
		String input = "This!!unusual use!!of exclamation!!points";
		print(Arrays.toString(Pattern.compile("!!").split(input)));
		// Only do the first three:
		print(Arrays.toString(
				Pattern.compile("!!").split(input, 3)));
		print(Arrays.toString(
				Pattern.compile("!!").split(input, 2)));
	}
} /* Output:
[This, unusual use, of exclamation, points]
[This, unusual use, of exclamation!!points]
[This, unusual use!!of exclamation!!points]
*///:~
