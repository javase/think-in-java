package strings;//: strings/JGrep.java
// A very simple version of the "grep" program.
// {Args: JGrep.java "\\b[Ssct]\\w+"}

import static net.mindview.util.Print.*;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.mindview.util.TextFile;

/**
 * 演示了如何应用正则表达式在一个文件中进行搜索匹配
 * 注意：在IDE配置args参数时，第二个参数是 \b[Ssct]\w+  而不是 \\b[Ssct]\\w+
 */
public class JGrep {
	public static void main(String[] args) throws Exception {
//		args = new String[2];
//		args[0] = "src/main/java/strings/JGrep.java";
//		args[1] = "\\b[Ssct]\\w+";
		printlnf("args:%s", Arrays.toString(args));

		if (args.length < 2) {
			System.out.println("Usage: java JGrep file regex");
			System.exit(0);
		}
		Pattern p = Pattern.compile(args[1]);
		// Iterate through the lines of the input file:
		int index = 0;
		Matcher m = p.matcher("");
		for (String line : new TextFile(args[0])) {
			m.reset(line);
			while (m.find()) {
				System.out.println(index++ + ": " + m.group() + ": " + m.start());
			}
		}
	}
} /* Output: (Sample)
0: strings: 4
1: simple: 10
2: the: 28
3: Ssct: 26
4: class: 7
5: static: 9
6: String: 26
7: throws: 41
8: System: 6
9: System: 6
10: compile: 24
11: through: 15
12: the: 23
13: the: 36
14: String: 8
15: System: 8
16: start: 31
*///:~
