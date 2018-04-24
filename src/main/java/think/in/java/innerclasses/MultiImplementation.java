//: innerclasses/MultiImplementation.java
// With concrete or abstract classes, inner
// classes are the only way to produce the effect
// of "multiple implementation inheritance."
package think.in.java.innerclasses;

class D {
}

abstract class E {
}

class Z extends D {

	/**
	 * 返回抽象类的实例
	 * @return
	 */
	E makeE() {
		return new E() {
		};
	}
}

/**
 * 一个类，通过内部类实现多重继承
 */
public class MultiImplementation {
	static void takesD(D d) {
	}

	static void takesE(E e) {
	}

	public static void main(String[] args) {
		Z z = new Z();
		takesD(z);
		takesE(z.makeE());
	}
} ///:~
