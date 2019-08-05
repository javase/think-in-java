package strings.exercise;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.mindview.util.TextFile;

/**
 * <pre>
 * 输出Java源文件中用到的所有类的名字
 * 类：首字母大写，如果一个类由多个单词构成，那么每个单词的首字母都大写，而且中间不使用任何的连接符。尽量使用英文。
 * </pre>
 */
public class E19_JClassUsageReporter {

	private static final String Identifier =
			"[$A-Za-z_][$A-Za-z_0-9]*";

	private static final String ClassOrInterfaceType =
			Identifier + "(?:\\." + Identifier + ")*";

	static final String CU_REP_REGEX =
			"class\\s+" + Identifier +
					"|extends\\s+" + ClassOrInterfaceType +
					"|new\\s+" + ClassOrInterfaceType;

	/**
	 * @param args src/main/java/strings/exercise/E19_JClassUsageReporter.java
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		if (args.length < 1) {
			// 故意写一个new String
			System.out.println(new String("Usage: java E19_JClassUsageReporter file"));
			System.exit(0);
		}
		String src = TextFile.read(args[0]);
		// Prune away comments ...
		src = src.replaceAll(E17_JCommentExtractor.CMNT_EXT_REGEX, "");
		// Prune away string literals ...
		src = src.replaceAll(
				E18_JStringExtractor.STR_EXT_REGEX, "");
		Pattern p = Pattern.compile(CU_REP_REGEX);
		Matcher m = p.matcher(src);
		while (m.find()) {
			System.out.println(m.group());
		}
	}
}

class B extends E19_JClassUsageReporter {
}