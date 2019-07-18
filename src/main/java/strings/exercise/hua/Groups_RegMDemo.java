package strings.exercise.hua;//: strings/Groups.java

import static net.mindview.util.Print.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * group用法举例
 * 示例：去掉(?m)和不去掉的区别
 * 去掉(?m)的正则表达式，将只匹配最后一行
 * (?m) 表示多行模式（"multi-line mode"），使正则的 ^ 和 $ 匹配字符串中每行的开始和结束
 */
public class Groups_RegMDemo {
	static public final String POEM =
			"Twas brillig, and the slithy toves\n" +
					"Did gyre and gimble in the wabe.\n" +
					"All mimsy were the borogoves,\n" +
					"And the mome raths outgrabe.\n\n" +
					"Beware the Jabberwock, my son,\n" +
					"The jaws that bite, the claws that catch.\n" +
					"Beware the Jubjub bird, and shun\n" +
					"The frumious Bandersnatch.";

	public static void main(String[] args) {
		/*
			捕获每行的最后三个词
			(?m) 为模式标记  包含了3个：(\\S+
			(?m)(\S+)\s+((\S+)\s+(\S+))$ 的详细解释：

			\S 匹配任何非空白字符（大写S）
			+ 匹配前面的子表达式一次或多次
			() 标记一个子表达式的开始和结束位置
			\s 匹配任何空白字符，包括空格、制表符、换页符等等。(小写s)
			$ 匹配输入字符串的结尾位置


		 */
		Matcher m =
				Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$")
						.matcher(POEM);
		printGroupInfo(m);

		printlnf("----------------------------------------");
		printlnf("去掉(?m)的正则表达式，将只匹配最后一行");
		m =
				Pattern.compile("(\\S+)\\s+((\\S+)\\s+(\\S+))$")
						.matcher(POEM);
		printGroupInfo(m);
		printlnf("\n\n\n");
	}

	private static void printGroupInfo(Matcher m) {
		while (m.find()) {
			for (int j = 0; j <= m.groupCount(); j++) {
				printnb("[" + m.group(j) + "]");
			}
			print();
		}
	}
} /* Output:
[the slithy toves][the][slithy toves][slithy][toves]
[in the wabe.][in][the wabe.][the][wabe.]
[were the borogoves,][were][the borogoves,][the][borogoves,]
[mome raths outgrabe.][mome][raths outgrabe.][raths][outgrabe.]
[Jabberwock, my son,][Jabberwock,][my son,][my][son,]
[claws that catch.][claws][that catch.][that][catch.]
[bird, and shun][bird,][and shun][and][shun]
[The frumious Bandersnatch.][The][frumious Bandersnatch.][frumious][Bandersnatch.]
*///:~
