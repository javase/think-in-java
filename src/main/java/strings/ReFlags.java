package strings;//: strings/ReFlags.java

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <pre>
 * 演示了
 * public static Pattern compile(String regex, int flags) {...}
 * 的用法
 * 可以使用(|)符号，来组合多个标记的功能
 * 注意：group()方法只返回已匹配的部分。
 * </pre>
 */
public class ReFlags {
	public static void main(String[] args) {
		Pattern p = Pattern.compile("^java",
				Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
		Matcher m = p.matcher(
				"java has regex\nJava has regex\n" +
						"JAVA has pretty good regular expressions\n" +
						"Regular expressions are in Java");
		while (m.find()) {
			System.out.println(m.group());
		}
	}
} /* Output:
java
Java
JAVA
*///:~
