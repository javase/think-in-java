package strings.exercise.hua;

import static net.mindview.util.Print.*;

import java.util.Scanner;

/**
 * 练习20
 * (2)编写一个包含int, long, float, double和String属性的类。
 * 为它编写一个构造器,接收一个String参数。然后扫描该字符串,为各个属性赋值。
 * 再添加一个toString()方法,用来演示你的类是否工作正确。
 * created at 2019-08-05 12:27
 * @author lerry
 */
public class E20_Scanner {

	private int int0;

	private float float0;

	private double double0;

	private String string0;

	public E20_Scanner(String initStr) {
		Scanner input = new Scanner(initStr);
		this.int0 = input.nextInt();
		this.float0 = input.nextFloat();
		this.double0 = input.nextDouble();
		this.string0 = input.nextLine();
	}

	@Override
	public String toString() {
		return "E20_Scanner{" +
				"int0=" + int0 +
				", float0=" + float0 +
				", double0=" + double0 +
				", string0='" + string0 + '\'' +
				'}';
	}

	public static void main(String[] args) {
		String initStr = "hi , 5 is int 600L is long 2.22f is float and 2.4d is double ";
		initStr = "5 600 2.22 str";
//		initStr = "1 10000000000000 1.1 1e55 Howdy Hi";
		printlnf(new E20_Scanner(initStr));
	}
}
