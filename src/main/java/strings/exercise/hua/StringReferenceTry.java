package strings.exercise.hua;

import net.mindview.util.Print;

/**
 * 我们发现，q对象本身，在传入方法前、后，并没有改变。如果要获取改变后的值，需要重新接收方法返回值的新对象。
 * created at 2019-06-13 12:41
 * @author lerry
 */
public class StringReferenceTry {

	/**
	 * 参数是为该方法提供信息的，而不是想让该方法改变自己的。
	 * @param s
	 * @return
	 */
	public static String upcase(String s) {
		return s.toUpperCase();
	}

	public static void main(String[] args) {
		String q = "howdy";
		Print.printlnf("字符串传入方法前：%s", q);
		upcase(q);
		Print.printlnf("字符串传入方法前：%s", q);
		Print.printlnf("方法返回值打印：%s", upcase(q));

	}
}
