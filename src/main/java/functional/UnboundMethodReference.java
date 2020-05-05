package functional;// functional/UnboundMethodReference.java
// (c)2017 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Method reference without an object

/**
 * On Java 8读书笔记-第十三章 函数式编程
 * 未绑定的方法引用
 * created at 2020-05-02 16:51
 * @author lerry
 */
public class UnboundMethodReference {
	public static void main(String[] args) {
		/*
		 * 我们尝试把 X 的 f() 方法引用赋值给 MakeString。
		 * 结果：即使 make() 与 f() 具有相同的签名，编译也会报“invalid method reference”（无效方法引用）错误。
		 * 这是因为实际上还有另一个隐藏的参数：我们的老朋友 this。
		 * 你不能在没有 X 对象的前提下调用 f()。
		 * 因此，X :: f 表示未绑定的方法引用，因为它尚未“绑定”到对象。
		 */
//		 MakeString ms = X::f; // [1]

		/*
		 * 如果将 X :: f 赋值给 TransformX，这在 Java 中是允许的。
		 * 这次我们需要调整下心里预期——使用未绑定的引用时，
		 * 函数方法的签名（接口中的单个方法）不再与方法引用的签名完全匹配。
		 * 理由是：你需要一个对象来调用方法。
		 */
		TransformX sp = X::f;
		X x = new X();
		System.out.println(sp.transform(x)); // [2]
		System.out.println(x.f()); // Same effect
	}
}

/* Output:
X::f()
X::f()
*/

/**
 * 就是一个类
 * created at 2020-05-02 16:52
 * @author lerry
 */
class X {
	/**
	 * 普通类的一个非静态方法
	 * @return
	 */
	String f() {
		return "X::f()";
	}
}

interface MakeString {
	String make();
}

/**
 * Transform: vt. 改变，使…变形；转换
 */
interface TransformX {
	String transform(X x);
}


