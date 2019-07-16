package strings;//: strings/TestRegularExpression.java
// Allows you to easily try out regular expressions.
// {Args: abcabcabcdefabc "abc+" "(abc)+" "(abc){2,}" }

import static net.mindview.util.Print.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 使用Pattern 和 Matcher，对字符串进行循环匹配
 * created at 2019-07-16 12:58
 * @author lerry
 */
public class TestRegularExpression {
	public static void main(String[] args) {
		args = new String[3];
		args[0] = "abcabcabcdefabc";
		args[1] = "abc+";
		args[2] = "(abc)+";

		if (args.length < 2) {
			print("Usage:\njava TestRegularExpression " +
					"characterSequence regularExpression+");
			System.exit(0);
		}
		print("Input: \"" + args[0] + "\"");
		for (String arg : args) {
			print("\nRegular expression: \"" + arg + "\"");
			Pattern p = Pattern.compile(arg);
			Matcher m = p.matcher(args[0]);
			while (m.find()) {
				print("Match \"" + m.group() + "\" at positions " +
						m.start() + "-" + (m.end() - 1));
			}
		}
	}
} /* Output:
Input: "abcabcabcdefabc"
Regular expression: "abcabcabcdefabc"
Match "abcabcabcdefabc" at positions 0-14
Regular expression: "abc+"
Match "abc" at positions 0-2
Match "abc" at positions 3-5
Match "abc" at positions 6-8
Match "abc" at positions 12-14
Regular expression: "(abc)+"
Match "abcabcabc" at positions 0-8
Match "abc" at positions 12-14
Regular expression: "(abc){2,}"
Match "abcabcabc" at positions 0-8
*///:~
