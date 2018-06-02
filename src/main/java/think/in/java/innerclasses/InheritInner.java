package think.in.java.innerclasses;//: innerclasses/InheritInner.java
// Inheriting an inner class.


import static net.mindview.util.Print.print;

class WithInner {

	public WithInner() {
		print("WithInner普通类的构造器");
	}

	class Inner {
		public Inner() {
			print("Inner类的构造器");
		}
	}
}

/**
 * 内部类的继承
 */
public class InheritInner extends WithInner.Inner {
	// 默认无参构造器编译不通过
	//! InheritInner() {} // Won't compile
	InheritInner(WithInner wi) {
		// 需要写在第一行  如果不写，编译也会报错
		wi.super();
		print("InheritInner继承类的构造器");
	}


	public static void main(String[] args) {
		WithInner wi = new WithInner();
		InheritInner ii = new InheritInner(wi);
	}
} ///:~
