package strings.exercise.hua;

import static net.mindview.util.Print.*;

import strings.Splitting;

/**
 * 替换Splitting.knights中的元音字母为下划线
 * (?i)支持不区分大小写的匹配
 * 正则表达式演示了如何处理大小写混合的元音(尽管上面没有出现)。
 * ()表示：标记一个子表达式的开始、结束位置；
 * ?：表示匹配前面的子表达式零次或一次
 * 不区分大小写的匹配也可以通过嵌入的标志表达式(?i)启用
 * created at 2019-07-15 12:33
 * @author lerry
 */
public class E09_Replacing2 {
	public static void main(String[] args) {
		// 大小写敏感
		String reg01 = "a|e|o|i|u|A|E|O|I|U";
		String reg02 = "(?i)[aeiou]";
		String reg03 = "(?i)(a|e|i|o|u)";
		printlnf(Splitting.knights.replaceAll(reg01, "_"));
		printlnf("另一种写法：");
		System.out.println(Splitting.knights.replaceAll(reg02, "_"));

		String abc = "ABCDEFGabcdefg";
		System.out.println(abc.replaceAll(reg01, "_"));
		System.out.println("另一种写法：");
		System.out.println(abc.replaceAll(reg02, "_"));
		System.out.println(abc.replaceAll(reg03, "_"));
	}
}
