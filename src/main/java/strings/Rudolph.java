package strings;//: strings/Rudolph.java

import static net.mindview.util.Print.*;

/**
 * n. 鲁道夫（男子名）
 * 用不一样的正则表达式，去匹配"Rudolph"
 */
public class Rudolph {
	public static void main(String[] args) {
		String[] strArray = new String[] {"Rudolph",
				"[rR]udolph", "[rR][aeiou][a-z]ol.*", "R.*"};
		for (String pattern : strArray) {
			printlnf("正则：%s matches 'Rudolph'：%s", pattern, "Rudolph".matches(pattern));
		}
	}
} /* Output:
正则：Rudolph matches 'Rudolph'：true
正则：[rR]udolph matches 'Rudolph'：true
正则：[rR][aeiou][a-z]ol.* matches 'Rudolph'：true
正则：R.* matches 'Rudolph'：true
*///:~
