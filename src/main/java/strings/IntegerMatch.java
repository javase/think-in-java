package strings;//: strings/IntegerMatch.java

/**
 * 正则表达式
 * created at 2019-06-28 19:44
 * @author lerry
 */
public class IntegerMatch {
	public static void main(String[] args) {
		System.out.println("-1234".matches("-?\\d+"));
		System.out.println("5678".matches("-?\\d+"));
		System.out.println("+911".matches("-?\\d+"));
		// 因为字符+在正则表达式中有特殊的意义，所以必须使用\\将其转义
		System.out.println("+911".matches("(-|\\+)?\\d+"));
	}
} /* Output:
true
true
false
true
*///:~
