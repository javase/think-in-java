package strings;//: strings/Finding.java

import static net.mindview.util.Print.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Finding {
	public static void main(String[] args) {

		// \w+ 将字符串划分为单词
		Matcher m = Pattern.compile("\\w+")
				.matcher("Evening is full of the linnet's wings");
		while (m.find()) {
			printnb(m.group() + " ");
		}
		print();

		int i = 0;
		// 根据其参数的值、不断重新设定搜索的起始位置
		while (m.find(i)) {
			printnb(m.group() + " ");
			i++;
		}
	}
} /* Output:
Evening is full of the linnet s wings
Evening vening ening ning ing ng g is is s full full ull ll l of of f the the he e linnet linnet innet nnet net et t s s wings wings ings ngs gs s
*///:~
