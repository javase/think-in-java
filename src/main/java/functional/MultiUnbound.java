package functional;// functional/MultiUnbound.java
// (c)2017 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Unbound methods with multiple arguments

/**
 * On Java 8读书笔记-第十三章 函数式编程
 * 未绑定的方法引用
 * created at 2020-05-02 17:04
 * @author lerry
 */
public class MultiUnbound {
	public static void main(String[] args) {
		TwoArgs twoargs = This::two;
		ThreeArgs threeargs = This::three;
		FourArgs fourargs = This::four;
		This athis = new This();
		twoargs.call2(athis, 11, 3.14);
		threeargs.call3(athis, 11, 3.14, "Three");
		fourargs.call4(athis, 11, 3.14, "Four", 'Z');
	}
}

class This {
	void two(int i, double d) {
	}

	void three(int i, double d, String s) {
	}

	void four(int i, double d, String s, char c) {
	}
}

interface TwoArgs {
	void call2(This athis, int i, double d);
}

interface ThreeArgs {
	void call3(This athis, int i, double d, String s);
}

interface FourArgs {
	void call4(This athis, int i, double d, String s, char c);
}

