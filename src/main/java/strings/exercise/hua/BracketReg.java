package strings.exercise.hua;

import static net.mindview.util.Print.*;

/**
 * 表达式通常必须要用圆括号括起来，以便它能够按照我们期望的效果去执行。
 * created at 2019-07-16 12:42
 * @author lerry
 */
public class BracketReg {
	public static void main(String[] args) {

		String text = "abcabcabc";

		// 表达的意思是： 匹配ab、后面跟随1个或多个c
		String reg01 = "abc+";
		// 表达的意思是：匹配abc
		String reg02 = "(abc)+";

		printlnf(text.replaceAll(reg01, "_"));
		printlnf(text.replaceAll(reg02, "_"));
		printlnf("正则表达式：%-10s\t匹配文本\t%-10s:\t%s", reg01, text, text.matches(reg01));
		printlnf("正则表达式：%-10s\t匹配文本\t%-10s:\t%s", reg02, text, text.matches(reg02));

		String newText = "abcccc";
		printlnf("正则表达式：%-10s\t匹配文本\t%-10s:\t%s", reg01, newText, newText.matches(reg01));
		printlnf("正则表达式：%-10s\t匹配文本\t%-10s:\t%s", reg02, newText, newText.matches(reg02));
	}
}
