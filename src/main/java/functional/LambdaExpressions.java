package functional;// functional/LambdaExpressions.java

// (c)2017 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

/**
 * <pre>
 * On Java 8读书笔记-第十三章 函数式编程
 * Lambda表达式的写法示例
 * Lambda 表达式是使用最小可能语法编写的函数定义：
 * Lambda 表达式产生函数，而不是类。
 * 在 JVM（Java Virtual Machine，Java 虚拟机）上，一切都是一个类，因此在幕后执行各种操作使 Lambda 看起来像函数 —— 但作为程序员，
 * 你可以高兴地假装它们“只是函数”。
 * Lambda 语法尽可能少，这正是为了使 Lambda 易于编写和使用。
 * Lambda 表达式通常比匿名内部类产生更易读的代码
 * </pre>
 * created at 2020-05-02 03:36
 * @author lerry
 */
public class LambdaExpressions {

	/**
	 * 当只用一个参数，可以不需要括号 ()。 然而，这是一个特例。
	 */
	static Body bod = h -> h + " No Parens!"; // [1]

	/**
	 * 正常情况使用括号 () 包裹参数。 为了保持一致性，也可以使用括号 () 包裹单个参数，
	 * 虽然这种情况并不常见。
	 */
	static Body bod2 = (h) -> h + " More details"; // [2]

	/**
	 * 如果没有参数，则必须使用括号 () 表示空参数列表。
	 */
	static Description desc = () -> "Short info"; // [3]

	/**
	 * 对于多个参数，将参数列表放在括号 () 中。
	 */
	static Multi mult = (h, n) -> h + n; // [4]

	/**
	 * 如果在 Lambda 表达式中确实需要多行，则必须将这些行放在花括号中。 在这种情况下，就需要使用 return。
	 */
	static Description moreLines = () -> { // [5]
		System.out.println("moreLines()");
		return "from moreLines()";
	};

	public static void main(String[] args) {
		System.out.println(bod.detailed("Oh!"));
		System.out.println(bod2.detailed("Hi!"));
		System.out.println(desc.brief());
		System.out.println(mult.twoArg("Pi! ", 3.14159));
		System.out.println(moreLines.brief());
	}
}

/* Output:
Oh! No Parens!
Hi! More details
Short info
Pi! 3.14159
moreLines()
from moreLines()
*/

/**
 * 我们从三个接口开始，每个接口都有一个单独的方法（很快就会理解它的重要性）。
 * 但是，每个方法都有不同数量的参数，以便演示 Lambda 表达式语法。
 */
interface Description {
	/**
	 * 没有入参、有返回值
	 * @return
	 */
	String brief();
}

interface Body {
	/**
	 * 有一个入参、有返回值
	 * @param head
	 * @return
	 */
	String detailed(String head);
}

interface Multi {
	/**
	 * 有两个入参，有返回值
	 * @param head
	 * @param d
	 * @return
	 */
	String twoArg(String head, Double d);
}


