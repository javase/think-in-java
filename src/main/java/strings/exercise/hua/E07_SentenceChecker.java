package strings.exercise.hua;

import static net.mindview.util.Print.*;

/**
 * 以大写字母开头，以英文句号结尾。注意：英文句号是特殊字符，需要使用\\进行转义
 * created at 2019-06-28 20:14
 * @author lerry
 */
public class E07_SentenceChecker {
	public static void main(String[] args) {
		String reg = "^\\p{Upper}.*\\.$";
		String content01 = "A capturing group can also be assigned a \"name\", a named-capturing group, and then be back-referenced later by the \"name\". Group names are composed of the following characters.";
		String content02 = "The first character must be a letter.";
		String content03 = "the first character must be a letter.";

		printlnf("[%s]是否以大写字母开头，以英文句号结尾？:%s", content01, content01.matches(reg));
		printlnf("[%s]是否以大写字母开头，以英文句号结尾？:%s", content02, content02.matches(reg));
		printlnf("[%s]是否以大写字母开头，以英文句号结尾？:%s", content03, content03.matches(reg));
	}
}
