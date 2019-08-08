package typeinfo.exercise;

import static net.mindview.util.Print.*;

interface HasBatteries {
}

interface Waterproof {
}

interface Shoots {
}

class Toy {
	Toy() {}
	Toy(int i) {
	}
}

class FancyToy extends Toy
		implements HasBatteries, Waterproof, Shoots {
	FancyToy() {
		super(1);
	}
}

/**
 * 把Toy类的默认构造器注释掉
 * 使用newInstance()来创建的类，必须带有默认的构造器
 * 必须为up.newInstance()定义所需的默认构造函数；编译器无法创建它，因为已经存在一个非默认构造函数。
 * created at 2019-08-08 12:29
 * @author lerry
 */
public class E01_ToyTest {
	public static void printInfo(Class<?> cc) {
		print("Class name: " + cc.getName() +
				" is interface? [" + cc.isInterface() + "]");
		print("Simple name: " + cc.getSimpleName());
		print("Canonical name : " + cc.getCanonicalName());
	}

	public static void main(String[] args) {
		Class<?> c = null;
		try {
			c = Class.forName("typeinfo.FancyToy");
		}
		catch (ClassNotFoundException e) {
			print("Can't find FancyToy");
			return;
		} printInfo(c);
		for (Class<?> face : c.getInterfaces()) {
			printInfo(face);
		}
		Class<?> up = c.getSuperclass();
		Object obj = null;
		try {
			// Requires default constructor:
			obj = up.newInstance();
		}
		catch (InstantiationException e) {
			print("Cannot instantiate");
			return;
		}
		catch (IllegalAccessException e) {
			print("Cannot access");
			return;
		}
		printInfo(obj.getClass());
	}
}
