package strings.exercise.hua;

import static net.mindview.util.Print.*;

/**
 * <pre>
 *     java.util.Formatter转换中，b符号，需要注意。
 *     对于非boolean类型的其他类型，只要改参数不为null，那转换结果就永远是true。
 *     即使是数字0，转换结果依然为true。
 * </pre>
 * created at 2019-06-27 12:56
 * @author lerry
 */
public class FormatterBDemo {
	public static void main(String[] args) {
		String str = "";
		printlnf("str \"\" [b占位符]:%b", str);
		int int01 = 0;
		printlnf("int 0 [b占位符]:%b", int01);
		Object obj = null;
		printlnf("Object null [b占位符]:%b", obj);
	}
}
