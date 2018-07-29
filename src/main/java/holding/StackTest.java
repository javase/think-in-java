package holding;//: holding/StackTest.java


/**
 * 这里使用的不是java.util.Stack ,而是使用LinkedList自己实现的Stack
 * 类似自助餐托盘
 * 先进后出
 */
public class StackTest {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		for (String s : "My dog has fleas".split(" ")) {
			// 压栈
			stack.push(s);
		}
		while (!stack.empty()) {
			// 出栈
			System.out.print(stack.pop() + "\t");
		}
	}
} /* Output:
fleas has dog My
*///:~
