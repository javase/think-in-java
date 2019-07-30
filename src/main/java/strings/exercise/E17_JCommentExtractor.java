package strings.exercise;

import static net.mindview.util.Print.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.mindview.util.TextFile;

/**
 * 读取一个Java源文件，打印出所有注释
 * 嵌入式标志表达式
 * created at 2019-07-30 12:18
 * @author lerry
 */
public class E17_JCommentExtractor {

	/**
	 * <pre>
	 *     (?x) 注释模式
	 *     (?m) 多行模式
	 *     (?s) 表达式 .可以匹配任何字符，包括行结束符
	 * </pre>
	 */
	static final String CMNT_EXT_REGEX = "(?x)(?m)(?s)/\\*(.*?)\\*/|//(.*?)$";

	public static void main(String[] args) throws Exception {
		if (args.length < 1) {
			System.out.println(
					"Usage: java E17_JCommentExtractor file");
			System.exit(0);
		}
		String src = TextFile.read(args[0]);
		Pattern p = Pattern.compile(CMNT_EXT_REGEX);
		Matcher m = p.matcher(src);

		// 打印匹配的行
		while (m.find()) {
			System.out.println(m.group(1) != null ?
					m.group(1) : m.group(2));
			printALine();
		}
	}
}
