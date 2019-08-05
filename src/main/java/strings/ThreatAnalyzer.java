package strings;//: strings/ThreatAnalyzer.java

import java.util.Scanner;
import java.util.regex.MatchResult;

/**
 * 扫描一个防火墙日志文件中记录的威胁数据
 * \\d: 数字：[0-9]
 * X+: X，一次或多次
 * X{n}：X，恰好 n 次
 */
public class ThreatAnalyzer {
	static String threatData =
			"58.27.82.161@02/10/2005\n" +
					"204.45.234.40@02/11/2005\n" +
					"58.27.82.161@02/11/2005\n" +
					"58.27.82.161@02/12/2005\n" +
					"58.27.82.161@02/12/2005\n" +
					"[Next log section with different data format]";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(threatData);
		String pattern = "(\\d+[.]\\d+[.]\\d+[.]\\d+)@" +
				"(\\d{2}/\\d{2}/\\d{4})";
		while (scanner.hasNext(pattern)) {
			scanner.next(pattern);
			// 获取Match匹配结果
			MatchResult match = scanner.match();
			String ip = match.group(1);
			String date = match.group(2);
			System.out.format("Threat on %s from %s\n", date, ip);
		}
	}
} /* Output:
Threat on 02/10/2005 from 58.27.82.161
Threat on 02/11/2005 from 204.45.234.40
Threat on 02/11/2005 from 58.27.82.161
Threat on 02/12/2005 from 58.27.82.161
Threat on 02/12/2005 from 58.27.82.161
*///:~
