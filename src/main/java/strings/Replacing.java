package strings;//: strings/Replacing.java

import static net.mindview.util.Print.*;

/**
 * String类的替换操作
 */
public class Replacing {
	static String s = Splitting.knights;

	public static void main(String[] args) {
		// f开头的，后面跟着一个或多个字母，只替换掉第一个匹配的部分。
		print(s.replaceFirst("f\\w+", "located"));
		// 三个单词中任意一个，替换所有匹配的部分
		print(s.replaceAll("shrubbery|tree|herring", "banana"));
	}
} /* Output:
Then, when you have located the shrubbery, you must cut down the mightiest tree in the forest... with... a herring!
Then, when you have found the banana, you must cut down the mightiest banana in the forest... with... a banana!
*///:~
