package typeinfo.exercise.hua;

import static net.mindview.util.Print.*;

/**
 * 打印一个对象的所有父类
 * created at 2019-08-13 12:46
 * @author lerry
 */
public class E08_RecursiveClassPrint {
	public static void main(String[] args) {
		printInheritance(new Integer(0));
	}

	public static void printInheritance(Object obj) {
		Class superCls = obj.getClass().getSuperclass();

		if (!"Object".equals(superCls.getSimpleName())) {
			printlnf("[%s]的父类是：[%s]", obj.getClass().getName(), superCls.getName());
			printInheritance(superCls);
		}
		else {
			printlnf("[%s]的父类是：[%s]", obj.getClass().getName(), superCls.getName());
			return;
		}

	}
}
