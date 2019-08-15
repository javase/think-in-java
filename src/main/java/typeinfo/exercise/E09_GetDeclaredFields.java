package typeinfo.exercise;

import static net.mindview.util.Print.*;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/**
 * 打印一个类中域的相关信息。
 * 再把域的类型信息也打印出来，递归打印。
 * 打印过的类型，下次就不再打印了。
 * 该程序使用了一个有趣的类层次结构的接口和复杂类型的组合。在这里，HashSet保持输出整洁，只显示一次字段。
 * created at 2019-08-15 12:22
 * @author lerry
 */
public class E09_GetDeclaredFields {

	static Set<Class<?>> alreadyDisplayed = new HashSet<>();

	static void printClasses(Class<?> c) {
		// getSuperclass() returns null on Object:
		if (c == null) {
			return;
		}
		printlnf("类名为：%s", c.getName());

		Field[] fields = c.getDeclaredFields();
		if (fields.length != 0) {
			print("域 Fields:");
		}
		for (Field fld : fields) {
			print("   " + fld);
		}
		for (Field fld : fields) {
			printALine();
			// 获取域的类型
			Class<?> fieldCls = fld.getType();
			if (!alreadyDisplayed.contains(fieldCls)) {
				printClasses(fieldCls);
				alreadyDisplayed.add(fieldCls);
			}
		}// Produces the interfaces that this class
		// implements:
		for (Class<?> k : c.getInterfaces()) {
			print("Interface: " + k.getName());
			printClasses(k.getSuperclass());
		}
		printClasses(c.getSuperclass());
	}

	/**
	 * typeinfo.exercise.Derived
	 * @param args
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws ClassNotFoundException {

		for (int i = 0; i < args.length; i++) {
			print("Displaying " + args[i]);
			printClasses(Class.forName(args[i]));
			if (i < args.length - 1) {
				printALineDouble();
			}
		}
	}
}

interface Iface {
	int i = 47;

	void f();
}

class Base implements Iface {
	String s;

	double d;

	@Override
	public void f() {
		System.out.println("Base.f");
	}
}

class Composed {
	Base b;
}

class Derived extends Base {
	Composed c;

	String s;
}