package excptions.exercise;

class Except1 extends Exception {
	public Except1(String s) {
		super(s);
	}
}

class BaseWithException {
	public BaseWithException() throws Except1 {
		throw new Except1("thrown by BaseWithException");
	}
}

/**
 * 记住，当您抛出异常时，编译器不会创建任何对象。
 * 这就是派生类构造函数不能捕获基类构造函数异常的原因:它不能从异常失败中“恢复”，因为没有基类子对象。
 */
class DerivedWE extends BaseWithException {
	// Produces compile-time error:
	//    unreported exception Except1
	// ! public DerivedWE() {}
	// Gives compile error: call to super must be
	// first statement in constructor:
	//! public DerivedWE() {
	//!   try {
	//!     super();
	//!   } catch(Except1 ex1) {
	//!   }
	//! }
	public DerivedWE() throws Except1 {
	}

}

/**
 * 派生类的构造器，不能捕获其基类构造器所抛出的异常
 */
public class E21_ConstructorExceptions {
	public static void main(String args[]) {
		try {
			new DerivedWE();
		}
		catch (Except1 ex1) {
//			System.out.println("Caught " + ex1);
			ex1.printStackTrace();
		}
	}
}
