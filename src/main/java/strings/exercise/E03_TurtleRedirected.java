package strings.exercise;

import java.io.PrintStream;
import java.util.Formatter;

/**
 * 包含了一个Formatter成员变量，用来格式化输出
 * 修改输出结果到：System.err
 */
public class E03_TurtleRedirected {

	private String name;

	private Formatter f;

	public E03_TurtleRedirected(String name, Formatter f) {
		this.name = name;
		this.f = f;
	}

	/**
	 * 移动到哪里
	 * @param x
	 * @param y
	 */
	public void move(int x, int y) {
		f.format("The E03_TurtleRedirected [%s] is at (%d,%d)\n", name, x, y);
	}

	public static void main(String[] args) {
		PrintStream outAlias = System.err;

		E03_TurtleRedirected tommy = new E03_TurtleRedirected("Tommy",
				new Formatter(System.err));
		E03_TurtleRedirected terry = new E03_TurtleRedirected("Terry",
				new Formatter(outAlias));
		tommy.move(0, 0);
		terry.move(4, 8);
		tommy.move(3, 4);
		terry.move(2, 5);
		tommy.move(3, 3);
		terry.move(3, 3);
	}
} /* Output:
Tommy The E03_TurtleRedirected is at (0,0)
Terry The E03_TurtleRedirected is at (4,8)
Tommy The E03_TurtleRedirected is at (3,4)
Terry The E03_TurtleRedirected is at (2,5)
Tommy The E03_TurtleRedirected is at (3,3)
Terry The E03_TurtleRedirected is at (3,3)
*///:~