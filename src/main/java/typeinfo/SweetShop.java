package typeinfo;//: typeinfo/SweetShop.java
// Examination of the way the class loader works.

import static net.mindview.util.Print.*;

class Candy {
	static { print("Loading Candy"); }
}

class Gum {
	static { print("Loading Gum"); }
}

class Cookie {
	static { print("Loading Cookie"); }
}

/**
 * 一旦某个类的Class对象被载入内存，它就被用来创建这个类的所有对象。
 * 可以看到类什么时候被加载了。
 */
public class SweetShop {
	public static void main(String[] args) {
		print("inside main");
		new Candy();
		print("After creating Candy");
		try {
			Class.forName("typeinfo.Gum");
		}
		catch (ClassNotFoundException e) {
			print("Couldn't find Gum");
		}
		print("After Class.forName(\"Gum\")");
		new Cookie();
		print("After creating Cookie");


	}
} /* Output:
inside main
Loading Candy
After creating Candy
Loading Gum
After Class.forName("Gum")
Loading Cookie
After creating Cookie
*///:~
