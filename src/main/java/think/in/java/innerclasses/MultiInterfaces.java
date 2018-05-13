//: innerclasses/MultiInterfaces.java
// Two ways that a class can implement multiple interfaces.
package think.in.java.innerclasses;

interface A {
}

interface B {
}

class X implements A, B {
}

class Y implements A {

	/**
	 * 返回B类型的实例
	 * @return
	 */
	B makeB() {
		// Anonymous inner class:
		return new B() {
		};
	}
}

/**
 * 在一个类中，实现两个接口
 */
public class MultiInterfaces {
	static void takesA(A a) {
	}

	static void takesB(B b) {
	}

	public static void main(String[] args) {
		X x = new X();
		Y y = new Y();
		takesA(x);
		takesA(y);
		takesB(x);
		takesB(y.makeB());
	}
} ///:~