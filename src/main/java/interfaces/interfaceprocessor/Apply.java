//: interfaces/interfaceprocessor/Apply.java
package interfaces.interfaceprocessor;

import static net.mindview.util.Print.*;

public class Apply {
	/**
	 * 可以接收Processor类型的对象
	 * @param p
	 * @param s
	 */
	public static void process(Processor p, Object s) {
		print("Using Processor " + p.name());
		print(p.process(s));
	}
} ///:~
