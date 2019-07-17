package strings.exercise;

import static net.mindview.util.Print.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Pattern和Matcher的练习
 * created at 2019-07-17 12:51
 * @author lerry
 */
public class E11_CheckForMatch2 {

	public static void main(String[] args) {
		// (?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b")
		String reg = "(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b";
		String context = "Arline ate eight apples and one orange while Anita hadn't any";
		Pattern pattern = Pattern.compile(reg);
		Matcher m = pattern.matcher(context);
		while (m.find()) {
			printlnf("Math \"%s\" at positions %s-%s", m.group(), m.start(), m.end() - 1);
		}
	}
}
