package strings.exercise;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static net.mindview.util.Print.printlnf;

/**
 * 用指定的正则表达式验证某个字符串，看能否匹配
 */
public class E10_CheckForMatch {

    public static void main(String[] args) {
        String source = "Java now has regular expressions";
        String[] regEx = {"^Java", "\\Breg.*",
                "n.w\\s+h(a|i)s", "s?", "s*", "s+", "s{4}", "s{1}.",
                "s{0,3}"};
        printlnf("Source string: %s", source);

        for (String reg : regEx) {
            Pattern pattern = Pattern.compile(reg);
            Matcher matcher = pattern.matcher(source);
            printlnf("\nreg is %s", reg);
            while (matcher.find()) {
                printlnf("Match \"%s\" at positions %s-%s", matcher.group(), matcher.start(), (matcher.end() - 1));
            }
        }
    }
}
