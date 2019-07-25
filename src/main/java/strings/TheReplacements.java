package strings;//: strings/TheReplacements.java

import static net.mindview.util.Print.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.mindview.util.TextFile;

/*! Here's a block of text to use as input to
    the regular expression matcher. Note that we'll
    first extract the block of text by looking for
    the special delimiters, then process the
    extracted block. !*/

/**
 * <pre>
 *     正则表达式特别便于替换文本。
 *     在 dotall 模式下,表达式 . 匹配任何字符,包括行终止符。默认情况下,此表达式与行终止符不匹配
 *     本程序进行的是：
 *     读取TheReplacements文件，然后匹配在/*!符号之间的所有文字。
 *     将存在两个或两个以上空格的地方，缩减为一个空格
 *     删除每行开头部分的空格
 * </pre>
 * created at 2019-07-25 12:44
 * @author lerry
 */
public class TheReplacements {
	public static void main(String[] args) throws Exception {
		String s = TextFile.read("src/main/java/strings/TheReplacements.java");
		// Match the specially commented block of text above:
		Matcher mInput =
				Pattern.compile("/\\*!(.*)!\\*/", Pattern.DOTALL).matcher(s);
		if (mInput.find()) {
			s = mInput.group(1); // Captured by parentheses
		}
		// Replace two or more spaces with a single space:
		s = s.replaceAll(" {2,}", " ");
		// Replace one or more spaces at the beginning of each
		// line with no spaces. Must enable MULTILINE mode:
		s = s.replaceAll("(?m)^ +", "");
		print(s);
		s = s.replaceFirst("[aeiou]", "(VOWEL1)");

		StringBuffer sbuf = new StringBuffer();
		Pattern p = Pattern.compile("[aeiou]");
		Matcher m = p.matcher(s);
		// Process the find information as you
		// perform the replacements:
		while (m.find()) {
			m.appendReplacement(sbuf, m.group().toUpperCase());
		}
		// Put in the remainder of the text:
		m.appendTail(sbuf);

		print(sbuf);
	}
} /* Output:
Here's a block of text to use as input to
the regular expression matcher. Note that we'll
first extract the block of text by looking for
the special delimiters, then process the
extracted block.
H(VOWEL1)rE's A blOck Of tExt tO UsE As InpUt tO
thE rEgUlAr ExprEssIOn mAtchEr. NOtE thAt wE'll
fIrst ExtrAct thE blOck Of tExt by lOOkIng fOr
thE spEcIAl dElImItErs, thEn prOcEss thE
ExtrActEd blOck.
*///:~
