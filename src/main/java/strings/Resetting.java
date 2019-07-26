package strings;//: strings/Resetting.java

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * reset()的用法：使用新的输入序列重置此匹配器
 * rug:小地毯
 * rig:装备
 */
public class Resetting {
	public static void main(String[] args) throws Exception {
		Matcher m = Pattern.compile("[frb][aiu][gx]").matcher("fix the rug with bags");
		while (m.find()) {
			System.out.print(m.group() + " ");
		}
		System.out.println();
		m.reset("fix the rig with rags");

		while (m.find()) {
			System.out.print(m.group() + " ");
		}
	}
} /* Output:
fix rug bag
fix rig rag
*///:~
