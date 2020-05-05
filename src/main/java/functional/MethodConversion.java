package functional;// functional/MethodConversion.java
// (c)2017 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.function.BiConsumer;

/**
 * <pre>
 * 第十三章 函数式编程 函数式接口
 * 实际上，如果我们将方法命名为 accept()，它就可以作为方法引用。
 * 但是我们也可用不同的名称，比如 someOtherName()。
 * 只要参数类型、返回类型与 BiConsumer 的 accept() 相同即可。
 * 因此，在使用函数接口时，名称无关紧要——只要参数类型和返回类型相同。
 * Java 会将你的方法映射到接口方法。
 * 要调用方法，可以调用接口的函数式方法名（在本例中为 accept()），而不是你的方法名。
 * </pre>
 */
public class MethodConversion {
	static void accept(In1 i1, In2 i2) {
		System.out.println("accept()");
	}

	static void someOtherName(In1 i1, In2 i2) {
		System.out.println("someOtherName()");
	}

	public static void main(String[] args) {
		BiConsumer<In1, In2> bic;

		bic = MethodConversion::accept;
		bic.accept(new In1(), new In2());

		bic = MethodConversion::someOtherName;
//		 bic.someOtherName(new In1(), new In2()); // Nope
		bic.accept(new In1(), new In2());
	}
}

class In1 {
}

class In2 {
}


/* Output:
accept()
someOtherName()
*/
