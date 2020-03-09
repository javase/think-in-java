package typeinfo.exercise;

import static net.mindview.util.Print.*;

interface HasCPU {
}

/**
 * 发烧友  带有CPU
 */
class FancierToy extends FancyToy implements HasCPU {
}

/**
 * 为FancierToy添加新的接口
 * created at 2019-08-08 12:33
 * @author lerry
 */
public class E02_ToyTest2 {
	public static void printInfo(Class<?> cc) {
		print("Class name: " + cc.getName() +
				" is interface? [" + cc.isInterface() + "]");
		print("Simple name: " + cc.getSimpleName());
		print("Canonical name : " + cc.getCanonicalName());
	}

	public static void main(String[] args) {
		Class<?> c = null;
		try {
			c = Class.forName("typeinfo.exercise.FancierToy");
		}
		catch (ClassNotFoundException e) {
			print("Can't find FancierToy");
			System.exit(1);
		}
		printInfo(c);
		printALine();
		for (Class<?> face : c.getInterfaces()) {
			printInfo(face);
		}
		Class<?> up = c.getSuperclass();
		Object obj = null;
		printALine();
		try {
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
} 