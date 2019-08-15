package typeinfo.exercise;

import static net.mindview.util.Print.*;

/**
 * 打印类继承体系的所有类
 * 我们稍微增强了解决方案，在FancyToy上运行它以打印所有接口。
 * created at 2019-08-13 12:56
 * @author lerry
 */
public class E08_RecursiveClassPrint {

	static void printClasses(Class<?> c) {
		if (c == null) {
			return;
		}
		Class superCls = c.getSuperclass();
		if(superCls != null){
			printlnf("[%s] extends [%s]", c.getName(), superCls.getName());
		}

		for (Class<?> anInterface : c.getInterfaces()) {
			printlnf("Interface:%s", anInterface.getName());
			printClasses(anInterface.getSuperclass());
		}
		printClasses(superCls);
	}

	/**
	 * @param args polymorphism.shape.Circle typeinfo.exercise.FancyToy
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		for (int i = 0; i < args.length; i++) {
			printALine();
			printlnf("Displaying %s", args[i]);
			printClasses(Class.forName(args[i]));
			if (i < args.length - 1) {
				printALine();
			}
		}
	}
}
