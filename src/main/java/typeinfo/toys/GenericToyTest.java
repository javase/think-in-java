//: typeinfo/toys/GenericToyTest.java
// Testing class Class.
package typeinfo.toys;

import static net.mindview.util.Print.*;

/**
 * up.newInstance()的返回值不是精确类型，而只是Object
 */
public class GenericToyTest {
	public static void main(String[] args) throws Exception {
		Class<FancyToy> ftClass = FancyToy.class;
		// Produces exact type:
		FancyToy fancyToy = ftClass.newInstance();
		Class<? super FancyToy> up = ftClass.getSuperclass();

		printlnf("FancyToy的基类是：%s", up);
		// This won't compile:
//		 Class<Toy> up2 = ftClass.getSuperclass();
		// Only produces Object:
		Object obj = up.newInstance();

		Toy toy = (Toy) up.newInstance();
		printlnf("Toy:%s", toy);
	}
} ///:~
