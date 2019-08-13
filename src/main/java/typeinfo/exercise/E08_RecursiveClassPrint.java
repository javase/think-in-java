package typeinfo.exercise;

import static net.mindview.util.Print.*;

/**
 * created at 2019-08-13 12:56
 * @author lerry
 */
public class E08_RecursiveClassPrint {

	static void printClasses(Class<?> c) {
		if (c == null) {
			return;
		}
		printlnf(c.getName());

		for (Class<?> anInterface : c.getInterfaces()) {
			printlnf("Interface:%s", anInterface.getName());
			printClasses(anInterface.getSuperclass());
		}
		printClasses(c.getSuperclass());
	}

	public static void main(String[] args) throws ClassNotFoundException {
		for (int i = 0; i < args.length; i++) {
			printlnf("Displaying %s", args[i]);
			printClasses(Class.forName(args[i]));
			if (i < args.length - 1) {
				printALine();
			}
		}
	}
}
