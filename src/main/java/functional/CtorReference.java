package functional;// functional/CtorReference.java

// (c)2017 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
/**
 * On Java 8读书笔记-第十三章 函数式编程
 * 你还可以捕获构造函数的引用，然后通过引用调用该构造函数。
 * created at 2020-05-05 06:24
 * @author lerry
 */
public class CtorReference {
	public static void main(String[] args) {
		/*
		 * 注意我们如何对 [1]，[2] 和 [3] 中的每一个使用 Dog :: new。
		 * 这 3 个构造函数只有一个相同名称：:: new，
		 * 但在每种情况下都赋值给不同的接口。
		 * 编译器可以检测并知道从哪个构造函数引用。
		 */
		MakeNoArgs mna = Dog::new; // [1]
		Make1Arg m1a = Dog::new;   // [2]
		Make2Args m2a = Dog::new;  // [3]

		Dog dn = mna.make();
		Dog d1 = m1a.make("Comet");
		Dog d2 = m2a.make("Ralph", 4);
	}
}

class Dog {
	String name;

	int age = -1; // For "unknown"

	Dog() {
		name = "stray";
	}

	Dog(String nm) {
		name = nm;
	}

	Dog(String nm, int yrs) {
		name = nm; age = yrs;
	}
}

interface MakeNoArgs {
	Dog make();
}

interface Make1Arg {
	Dog make(String nm);
}

interface Make2Args {
	Dog make(String nm, int age);
}


