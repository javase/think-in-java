package strings.exercise.hua;

import static net.mindview.util.Print.*;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import strings.Groups;

/**
 * 找出所有不以大写字母开头的词，不重复地计算其个数
 * created at 2019-07-18 07:50
 * @author lerry
 */
public class E12_Groups2 {
	public static void main(String[] args) {

		Set<String> set = new HashSet<>();
		String reg = "(?m)(\\b([^\\p{Upper}]\\w+))\\b";


		// 参考答案写的
		/*
			详解：
			\\b\\w+\\b表示的正则表达式允许执行"全词"的搜索
			\\b 匹配一个单词边界，即字与空格间的位置
		 */
		reg = "\\b((?![A-Z])\\w+)\\b";
		Matcher m = Pattern.compile(reg).matcher(Groups.POEM);
		while (m.find()) {
			printlnf("%s", m.group());
			set.add(m.group());
		}
		printf("所有不以大写字母开头的词有 %d 个\n\n", set.size());
	}
}
