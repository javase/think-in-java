package strings.exercise;

import static net.mindview.util.Print.*;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.mindview.util.TextFile;

/**
 * 接受目录名或文件
 * args[]: src/main/java/common \b[Ssct]\w+
 */
public class E16_JGrep3 {
	public static void main(String[] args) throws Exception {
		if (args.length < 2) {
			System.out.println("Usage: java E16_JGrep3 file regex");
			System.exit(0);
		}

		printlnf("输入的路径为：%s", args[0]);
		File file = new File(args[0]);
		File[] files = null;
		if (file.isDirectory()) {
			files = file.listFiles();
		}
		else {
			files = new File[] {new File(args[0])};
		}
		Pattern p = Pattern.compile(args[1]);
		Matcher m = p.matcher("");
		for (File f : files) {
			System.out.println("\n-- File:" + f.getName() + "--");
			// Iterate through the lines of the input file:
			int index = 0;


			if (f.isFile()) {
				for (String line : new TextFile(f.getAbsolutePath())) {
					m.reset(line);
					while (m.find()) {
						System.out.println(index++ + ": " +
								m.group() + ": " + m.start());
					}
				}
			}
			else {
				printlnf("===%s不是文件===", f.getName());
			}
		}
	}
} /* Output: (Sample)
         输入的路径为：src/main/java/common

-- File:Range.java--
0: creation: 9
1: that: 26
2: can: 31
3: SE5: 26
4: static: 30
5: common: 8
6: class: 7
7: sequence: 17
8: static: 11
9: sequence: 17
10: start: 27
11: static: 11
12: start: 34
13: sz: 12
14: start: 23
15: sz: 31
16: sz: 28
17: start: 15
18: sequence: 17
19: start: 27
20: step: 55
21: static: 11
22: start: 34
23: step: 54
24: sz: 12
25: start: 24
26: step: 33
27: sz: 31
28: sz: 28
29: start: 15
30: step: 28
         *///:~