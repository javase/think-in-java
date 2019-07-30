package strings.exercise;

import static net.mindview.util.Print.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.mindview.util.TextFile;

/**
 * 接收模式标志参数
 * args[]: src/main/java/strings/exercise/E15_JGrep2.java \b[Ssct]\w+ CASE_INSENSITIVE
 */
public class E15_JGrep2 {
	public static void main(String[] args) throws Exception {
		if (args.length < 3) {
			print("Usage: java E15_JGrep2 file regex pattern");
			print("pattern can take one of the following values");
			print("CANON_EQ, CASE_INSENSITIVE, COMMENTS, " +
					"DOTALL, MULTILINE, UNICODE_CASE, UNIX_LINES");
			System.exit(0);
		}
		int flag = 0;
		if (args[2].equalsIgnoreCase("CANON_EQ")) {
			flag = Pattern.CANON_EQ;
		}
		else if (args[2].equalsIgnoreCase("CASE_INSENSITIVE")) {
			flag = Pattern.CASE_INSENSITIVE;
		}
		else if (args[2].equalsIgnoreCase("COMMENTS")) {
			flag = Pattern.COMMENTS;
		}
		else if (args[2].equalsIgnoreCase("DOTALL")) {
			flag = Pattern.DOTALL;
		}
		else if (args[2].equalsIgnoreCase("MULTILINE")) {
			flag = Pattern.MULTILINE;
		}
		else if (args[2].equalsIgnoreCase("UNICODE_CASE")) {
			flag = Pattern.UNICODE_CASE;
		}
		else if (args[2].equalsIgnoreCase("UNIX_LINES")) {
			flag = Pattern.UNIX_LINES;
		}
		Pattern p = Pattern.compile(args[1], flag);
		// Iterate through the lines of the input file:
		int index = 0;
		Matcher m = p.matcher("");
		for (String line : new TextFile(args[0])) {
			m.reset(line);
			while (m.find()) {
				print(index++ + ": " + m.group() + ": " +
						m.start());
			}
		}
	}
} /* Output: (Sample)
0: strings: 4
1: Ssct: 30
2: CASE_INSENSITIVE: 40
3: to: 21
4: CASE_INSENSITIVE: 11
5: static: 7
6: class: 7
         7: static: 9
         8: String: 26
         9: throws: 41
         10: can: 21
         11: take: 25
         12: the: 37
         13: CANON_EQ: 13
         14: CASE_INSENSITIVE: 23
         15: COMMENTS: 41
         16: System: 6
         17: CANON_EQ: 33
         18: CANON_EQ: 21
         19: CASE_INSENSITIVE: 35
         20: CASE_INSENSITIVE: 21
         21: COMMENTS: 40
         22: COMMENTS: 21
         23: compile: 24
         24: through: 15
         25: the: 23
         26: the: 36
         27: String: 8
         28: TextFile: 26
         29: start: 12
         *///:~