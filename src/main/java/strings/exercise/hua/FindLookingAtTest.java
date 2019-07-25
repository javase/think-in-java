package strings.exercise.hua;

import static net.mindview.util.Print.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <pre>
 * find:部分匹配，从当前位置开始匹配，找到一个匹配的子串，将移动下次匹配的位置。
 * matches:整个匹配，只有整个字符序列完全匹配成功，才返回True，否则返回False。但如果前部分匹配成功，将移动下次匹配的位置。
 * lookingAt:部分匹配，总是从第一个字符进行匹配,匹配成功了不再继续匹配，匹配失败了,也不继续匹配。
 * </pre>
 */
public class FindLookingAtTest {
	public static void main(String[] args) {
		/**
		 * \\d ： 匹配一个数字
		 * \d{3,5} 表示匹配至少 3 个最多 5 个数字
		 */
		String reg = "\\d{3,5}";
		Pattern pattern = Pattern.compile(reg);
		String charSequence = "123-34345-234-00";

		Matcher matcher = pattern.matcher(charSequence);

		printlnf("\ntext is [%s]\nreg is [%s]\n", charSequence, reg);
		//虽然匹配失败，但由于charSequence里面的"123"和pattern是匹配的,所以下次的匹配从位置4开始
		printlnf("matcher.matches():%s", matcher.matches());

		//测试匹配位置
		matcher.find();
		printlnf("matcher.find()后，测试匹配位置，matcher.start():%s", matcher.start());

		String text02 = "12345";
		printlnf("\ntext02 is [%s]\nreg is [%s]\n", text02, reg);
		Matcher matcher02 = pattern.matcher(text02);
		printlnf("matcher02.matches():%s", matcher02.matches());

		//使用reset方法重置匹配位置
		matcher.reset();

		printlnf("--------------------------------------------");

		//第一次find匹配以及匹配的目标和匹配的起始位置
		print(matcher.find());
		printlnf("第1次find匹配以及匹配的目标和匹配的起始位置:[group()]:%s [start()]:%s", matcher.group(), matcher.start());
		//第二次find匹配以及匹配的目标和匹配的起始位置
		print(matcher.find());
		printlnf("第2次find匹配以及匹配的目标和匹配的起始位置:[group()]:%s [start()]:%s", matcher.group(), matcher.start());

		printlnf("--------------------------------------------");

		//第一次lookingAt匹配以及匹配的目标和匹配的起始位置
		print(matcher.lookingAt());
		printlnf("第1次lookingAt匹配以及匹配的目标和匹配的起始位置:[group()]:%s [start()]:%s", matcher.group(), matcher.start());

		//第二次lookingAt匹配以及匹配的目标和匹配的起始位置
		print(matcher.lookingAt());
		printlnf("第2次lookingAt匹配以及匹配的目标和匹配的起始位置:[group()]:%s [start()]:%s", matcher.group(), matcher.start());
	}

}
