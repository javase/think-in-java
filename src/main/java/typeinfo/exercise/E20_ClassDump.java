package typeinfo.exercise;

import static net.mindview.util.Print.*;

/**
 * 请从在http://java.sun.com上提供的JDK文档中找出java.lang.Class的接口。写一
 * 个程序，使它能够接受命令行参数所指定的类名称。然后使用Class的方法打印该类所有可以获
 * 得的信息。用标准程序库的类和你自己写的类，分别测试这个程序。
 */
public class E20_ClassDump {
	public static void display(String msg, Object[] vals) {
		print(msg);
		for (Object val : vals) {
			print("   " + val);
		}
	}

	public static void classInfo(Class<?> c) throws Exception {
		print("c.getName(): " + c.getName());
		print("c.getPackage(): " + c.getPackage());
		print("c.getSuperclass(): " + c.getSuperclass());
		// This produces all the classes declared as members:
		display("c.getDeclaredClasses()",
				c.getDeclaredClasses());
		display("c.getClasses()", c.getClasses());
		display("c.getInterfaces()", c.getInterfaces());
		// The "Declared" version includes all
		// versions, not just public:
		display("c.getDeclaredMethods()",
				c.getDeclaredMethods());
		display("c.getMethods()", c.getMethods());
		display("c.getDeclaredConstructors()",
				c.getDeclaredConstructors()); display("c.getConstructors()", c.getConstructors());
		display("c.getDeclaredFields()",
				c.getDeclaredFields());
		display("c.getFields()", c.getFields());
		if (c.getSuperclass() != null) {
			print("Base class: --------");
			classInfo(c.getSuperclass());
		}
		print("End of " + c.getName());
	}

	public static void main(String[] args) throws Exception {
		args = new String[2];
		args[0] = "java.lang.String";
		args[1] = "java.lang.NullPointerException";
		for (String arg : args) {
			classInfo(Class.forName(arg));
			printALineDouble();
		}
	}
} /* (Execute to see output) *///:~