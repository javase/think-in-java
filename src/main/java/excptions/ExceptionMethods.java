package excptions;//: exceptions/ExceptionMethods.java
// Demonstrating the Exception Methods.

import static net.mindview.util.Print.*;

/**
 * <pre>
 * 演示如何使用Exception类型的方法。
 * 每个方法都比前一个提供了更多信息——实际上，它们每一个都是前一个的超集
 * 定义：如果一个集合S2中的每一个元素都在集合S1中，且集合S1中可能包含S2中没有的元素，则集合S1就是S2的一个超集，反过来，S2是S1的子集。 S1是S2的超集，若S1中一定有S2中没有的元素，则S1是S2的真超集，反过来S2是S1的真子集。
 * </pre>
 */
public class ExceptionMethods {
	public static void main(String[] args) {
		try {
			throw new Exception("My Exception");
		}
		catch (Exception e) {
			print("Caught Exception");
			print("getMessage():" + e.getMessage());
			print("getLocalizedMessage():" +
					e.getLocalizedMessage());
			print("toString():" + e);
			print("printStackTrace():");
			e.printStackTrace(System.out);
		}
	}
} /* Output:
Caught Exception
getMessage():My Exception
getLocalizedMessage():My Exception
toString():java.lang.Exception: My Exception
printStackTrace():
java.lang.Exception: My Exception
        at ExceptionMethods.main(ExceptionMethods.java:8)
*///:~
