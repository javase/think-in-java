package functional;// functional/FunctionalAnnotation.java
// (c)2017 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.


//import generics.Functional;

/**
 * 第十三章 函数式编程 函数式接口
 * created at 2020-05-07 12:34
 * @author lerry
 */
public class FunctionalAnnotation {

	public String goodbye(String arg) {
		return "Goodbye, " + arg;
	}

	public static void main(String[] args) {
		FunctionalAnnotation fa = new FunctionalAnnotation();

		/*
		 * Functional 和 FunctionalNoAnn 定义接口，
		 * 然而被赋值的只是方法 goodbye()。
		 * 首先，这只是一个方法而不是类；
		 * 其次，它甚至都不是实现了该接口的类中的方法。
		 * Java 8 在这里添加了一点小魔法：如果将方法引用或 Lambda 表达式赋值给函数式接口（类型需要匹配），
		 * Java 会适配你的赋值到目标接口。
		 * 编译器会自动包装方法引用或 Lambda 表达式到实现目标接口的类的实例中。
		 */
		Functional f = fa::goodbye;
		FunctionalNoAnn fna = fa::goodbye;
		/*
		 * 尽管 FunctionalAnnotation 确实适合 Functional 模型，
		 * 但 Java 不允许我们将 FunctionalAnnotation 像 fac 定义一样直接赋值给 Functional，
		 * 因为它没有明确地实现 Functional 接口。
		 * 令人惊奇的是 ，Java 8 允许我们以简便的语法为接口赋值函数。
		 */
//		 Functional fac = fa; // Incompatible
		Functional fl = a -> "Goodbye, " + a;

		FunctionalNoAnn fnal = a -> "Goodbye, " + a;
	}
}

@FunctionalInterface
interface Functional {
	String goodbye(String arg);
}

interface FunctionalNoAnn {
	String goodbye(String arg);
}

/*
@FunctionalInterface
interface NotFunctional {
  String goodbye(String arg);
  String hello(String arg);
}
Produces error message:
NotFunctional is not a functional interface
multiple non-overriding abstract methods
found in interface NotFunctional
*/


