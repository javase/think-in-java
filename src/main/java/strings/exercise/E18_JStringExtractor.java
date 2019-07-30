package strings.exercise;

import static net.mindview.util.Print.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.mindview.util.TextFile;

/**
 * 打印代码中所有的普通字符串(""之间的内容)
 * created at 2019-07-30 12:53
 * @author lerry
 */
public class E18_JStringExtractor {
	static final String STR_EXT_REGEX =
			"\"(?:[^\"\\\\\\n\\r]|(?:\\\\(?:[untbrf\\\\'\"]"
					+ "|[0-9A-Fa-f]{4}|[0-7]{1,2}|[0-3][0-7]{2})))*\"";

	public static void main(String[] args) throws Exception {
		if (args.length < 1) {
			System.out.println(
					"Usage: java E18_JStringExtractor file");
			System.exit(0);
		}
		String src = TextFile.read(args[0]);
		Pattern p = Pattern.compile(STR_EXT_REGEX);
		Matcher m = p.matcher(src);
		while (m.find()) {
			System.out.println(m.group().
					substring(1, m.group().length() - 1));
			printALine();
		}
		// "This is NOT a string but a comment!"
		String dummy = "\u003F\u003f\n\060\607";
	}
}
