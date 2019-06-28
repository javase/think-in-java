package strings.exercise;

/**
 * 以大写字母开头，以英文句号结尾。注意：英文句号是特殊字符，需要使用\\进行转义
 * created at 2019-06-28 20:14
 * @author lerry
 */
public class E07_SentenceChecker {
	public static boolean matches(String text) {
		return text.matches("\\p{javaUpperCase}.*\\.");
	}

	public static void main(String[] args) {
		System.out.println(matches("This is correct."));
		System.out.println(matches("bad sentence 1."));
		System.out.println(matches("Bad sentence 2"));
		System.out.println(matches("This is also correct..."));
	}
} /* Output:
         true
         false
         false
         true
         *///:~
