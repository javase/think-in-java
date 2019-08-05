package strings;//: strings/ScannerDelimiter.java

import java.util.Scanner;

/**
 * 默认情况下，Scanner根据空白字符对输入进行分词
 * 可以使用正则表达式指定自己所需要的定界符
 * /s 空白字符：[ \t\n\x0B\f\r]
 * X* X，零次或多次
 * 本例子中，使用的定界符是： 逗号前后任意的空白字符
 */
public class ScannerDelimiter {
	public static void main(String[] args) {
		Scanner scanner = new Scanner("12,    42, \t78, \n99, " +
				"\n\n42");
		scanner.useDelimiter("\\s*,\\s*");
		while (scanner.hasNextInt()) {
			System.out.println(scanner.nextInt());
		}
	}
} /* Output:
12
42
78
99
42
*///:~
