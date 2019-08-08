//: typeinfo/toys/ToyTest.java
// Testing class Class.
package typeinfo.toys;

import static net.mindview.util.Print.*;

/**
 * 有电池
 * created at 2019-08-08 12:18
 * @author lerry
 */
interface HasBatteries {
}

/**
 * 防水
 * created at 2019-08-08 12:18
 * @author lerry
 */
interface Waterproof {
}

/**
 * 射击
 * created at 2019-08-08 12:18
 * @author lerry
 */
interface Shoots {
}

/**
 * 玩具
 * created at 2019-08-08 12:17
 * @author lerry
 */
class Toy {
	// Comment out the following default constructor
	// to see NoSuchMethodError from (*1*)
	Toy() {
	}

	Toy(int i) {
	}
}

/**
 * 儿童益智玩具
 * created at 2019-08-08 12:17
 * @author lerry
 */
class FancyToy extends Toy
		implements HasBatteries, Waterproof, Shoots {
	FancyToy() {
		super(1);
	}
}

/**
 * Class 包含很多有用的方法
 * created at 2019-08-08 12:11
 * @author lerry
 */
public class ToyTest {
	static void printInfo(Class cc) {
		print("Class name: " + cc.getName() +
				" is interface? [" + cc.isInterface() + "]");
		print("Simple name: " + cc.getSimpleName());
		// canonical ： 经典的；（数学表达式）最简洁的；准确的；权威的；公认的；
		print("Canonical name : " + cc.getCanonicalName());
	}

	public static void main(String[] args) {
		Class c = null;
		try {
			// 传递给forName的字符串中，必须使用全限定名
			c = Class.forName("typeinfo.toys.FancyToy");
		}
		catch (ClassNotFoundException e) {
			print("Can't find FancyToy");
			System.exit(1);
		}
		printInfo(c);


		printALine();
		for (Class face : c.getInterfaces()) {
			printInfo(face);
		}

		printALine();
		Class up = c.getSuperclass();
		Object obj = null;
		try {
			// Requires default constructor:
			obj = up.newInstance();
		}
		catch (InstantiationException e) {
			print("Cannot instantiate");
			System.exit(1);
		}
		catch (IllegalAccessException e) {
			print("Cannot access");
			System.exit(1);
		}
		printInfo(obj.getClass());
	}
} /* Output:
Class name: typeinfo.toys.FancyToy is interface? [false]
Simple name: FancyToy
Canonical name : typeinfo.toys.FancyToy
Class name: typeinfo.toys.HasBatteries is interface? [true]
Simple name: HasBatteries
Canonical name : typeinfo.toys.HasBatteries
Class name: typeinfo.toys.Waterproof is interface? [true]
Simple name: Waterproof
Canonical name : typeinfo.toys.Waterproof
Class name: typeinfo.toys.Shoots is interface? [true]
Simple name: Shoots
Canonical name : typeinfo.toys.Shoots
Class name: typeinfo.toys.Toy is interface? [false]
Simple name: Toy
Canonical name : typeinfo.toys.Toy
*///:~
