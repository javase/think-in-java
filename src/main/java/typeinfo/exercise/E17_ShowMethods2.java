package typeinfo.exercise;
// Using reflection to show all the methods of a class,
// even if the methods are defined in the base class.
// {Args: ShowMethods}

import static net.mindview.util.Print.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * 自动展示完整接口的简单工具  把基类型的接口方法也给展示了出来
 * 练习：修改正则表达式 去掉final和native关键字  备注：\\s可以去除多余的空格
 */
public class E17_ShowMethods2 {
	private static String usage =
			"usage:\n" +
					"ShowMethods qualified.class.name\n" +
					"To show all methods in class or:\n" +
					"ShowMethods qualified.class.name word\n" +
					"To search for methods involving 'word'";

	// 去掉了命名修饰符 如： public java.lang.String java.lang.String.toString()  转为： public String toString()
	private static Pattern p = Pattern.compile("\\w+\\.|final\\s|native\\s");

	/**
	 * @param args java.lang.String
	 */
	public static void main(String[] args) {

		if (args.length < 1) {
			print(usage);
			System.exit(0);
		}
		int lines = 0;
		try {
			Class<?> c = Class.forName(args[0]);
			// 这些对象反映由此Class对象表示的类或接口的所有公共成员方法，包括由类或接口声明的方法以及从超类和超接口继承的方法。
			Method[] methods = c.getMethods();
			// 构造器数组
			Constructor[] ctors = c.getConstructors();

			// 只处理一个输入参数时
			if (args.length == 1) {
				for (Method method : methods) {
					print(p.matcher(method.toString()).replaceAll(""));
				}

				print("\nConstructors:\n");
				for (Constructor ctor : ctors) {
					print(p.matcher(ctor.toString()).replaceAll(""));
				}
				lines = methods.length + ctors.length;
			}
			else {
				for (Method method : methods) {
					if (method.toString().indexOf(args[1]) != -1) {
						print(p.matcher(method.toString()).replaceAll(""));
						lines++;
					}
				}
				for (Constructor ctor : ctors) {
					if (ctor.toString().indexOf(args[1]) != -1) {
						print(p.matcher(
								ctor.toString()).replaceAll(""));
						lines++;
					}
				}
			}
		}
		catch (ClassNotFoundException e) {
			print("No such class: " + e);
		}
	}
} /* Output:
public static void main(String[])
public native int hashCode()
public final native Class getClass()
public final void wait(long,int) throws InterruptedException
public final void wait() throws InterruptedException
public final native void wait(long) throws InterruptedException
public boolean equals(Object)
public String toString()
public final native void notify()
public final native void notifyAll()
public ShowMethods()
*///:~
