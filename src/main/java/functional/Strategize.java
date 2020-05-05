package functional;// functional/Strategize.java

// (c)2017 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
public class Strategize {
	Strategy strategy;

	String msg;

	/**
	 * Soft 作为默认策略，在构造函数中赋值。
	 * @param msg
	 */
	Strategize(String msg) {
		strategy = new Soft(); // [1]
		this.msg = msg;
	}

	/**
	 * communicate:通信, 沟通, 传达
	 */
	void communicate() {
		System.out.println(strategy.approach(msg));
	}

	void changeStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public static void main(String[] args) {
		// 一种略显简短且更自发的方法是创建一个匿名内部类。即使这样，仍有相当数量的冗余代码。
		// 你总是要仔细观察：“哦，原来这样，这里使用了匿名内部类。”
		Strategy[] strategies = {
				new Strategy() { // [2]
					@Override
					public String approach(String msg) {
						return msg.toUpperCase() + "!";
					}
				},
				// Java 8 的 Lambda 表达式。由箭头 -> 分隔开参数和函数体，箭头左边是参数，箭头右侧是从 Lambda 返回的表达式，即函数体。
				// 这实现了与定义类、匿名内部类相同的效果，但代码少得多。
				msg -> msg.substring(0, 5), // [3]
				// Java 8 的方法引用，由 :: 区分。在 :: 的左边是类或对象的名称，在 :: 的右边是方法的名称，但没有参数列表。
				Unrelated::twice // [4]
		};
		Strategize s = new Strategize("Hello there");
		s.communicate();
		for (Strategy newStrategy : strategies) {
			s.changeStrategy(newStrategy); // [5]
			s.communicate(); // [6]
		}
	}
}

/* Output:
hello there?
HELLO THERE!
Hello
Hello there Hello there
*/

/**
 * Strategy 接口提供了单一的 approach() 方法来承载函数式功能
 */
interface Strategy {
	/**
	 * approach:途径
	 * @param msg
	 * @return
	 */
	String approach(String msg);
}

/**
 * Soft 作为默认策略，在构造函数中赋值。
 */
class Soft implements Strategy {
	@Override
	public String approach(String msg) {
		return msg.toLowerCase() + "?";
	}
}

class Unrelated {
	static String twice(String msg) {
		return msg + " " + msg;
	}
}


