package strings;//: strings/Splitting.java

import java.util.Arrays;

/**
 * String类的split()方法。
 * 在原始字符串中，与正则表达式匹配的部分，在最终结果中都不存在了。
 */
public class Splitting {
	public static String knights =
			"Then, when you have found the shrubbery, you must " +
					"cut down the mightiest tree in the forest... " +
					"with... a herring!";

	public static void split(String regex) {
		System.out.println(Arrays.toString(knights.split(regex)));
	}

	public static void main(String[] args) {
		// Doesn't have to contain regex chars
		// 按照空格来划分
		split(" ");
		// Non-word characters
		// \W 非单词字符  \w 表示一个单词字符  将标点符号删除了
		split("\\W+");
		// 'n' followed by non-word characters
		// n： 字母n后面跟着一个或多个非单词字符
		split("n\\W+");
	}
} /* Output:
[Then,, when, you, have, found, the, shrubbery,, you, must, cut, down, the, mightiest, tree, in, the, forest..., with..., a, herring!]
[Then, when, you, have, found, the, shrubbery, you, must, cut, down, the, mightiest, tree, in, the, forest, with, a, herring]
[The, whe, you have found the shrubbery, you must cut dow, the mightiest tree i, the forest... with... a herring!]
*///:~
