package strings.exercise.hua;

import static net.mindview.util.Print.*;

import java.util.Formatter;
import java.util.Locale;

/**
 * created at 2019-06-28 12:39
 * @author lerry
 */
public class E05_ComplexConversion {
	public static void main(String[] args) {
		// 输出到控制台
		Formatter formatter = new Formatter(System.out);
		char u = 'a';
		formatter.format("c[$-10]: %1$-10c\n", u);
		formatter.format("c[$-1]: %1$-1c\n", u);
		formatter.format("c[%%c]: %c\n", u);


		// 备注说明： %s  说明一个占位符   4$ 标识第四个参数  4$2后面的2，表示输出时，该参数前面有2个空格
		//  %[argument_index$][flags][width]conversion
		formatter.format("占位符输出  %4$2s %3$2s %2$2s %1$2s\n", "a", "b", "c", "d");

		// Optional locale as the first argument can be used to get ocale-specific formatting of numbers.  The precision and width can be given to round and align the value.
		formatter.format("Math.E is %s\n", Math.E);
		// -> "e =    +2,7183"
		formatter.format(Locale.FRANCE, "e[+10.4f]=%+10.4f\n", Math.E);
		formatter.format(Locale.FRANCE, "e[10.4f]=%10.4f\n", Math.E);
		formatter.format(Locale.FRANCE, "e[20.4f]=%20.4f\n", Math.E);
		formatter.format(Locale.FRANCE, "e[.4f限制4位精度] =%.4f\n", Math.E);
		formatter.format("[+10.4f]中，%s代表符号'+'，%s表示宽度占位符，%s表示精度\n", "+", 10, ".4");

		printlnf("------------------------------");
		formatter.format("%1$(,010d\n", 156);
		formatter.format("在指定数字前，添加0补全不足的位数： %1$010d\n", 156);

	}
}
