package typeinfo.exercise;

import static net.mindview.util.Print.*;

/**
 * <pre>
 * 判断数组究竟是基本类型、还是一个对象？
 * 数组也是一个Java对象
 * 所有数组类名称都以“[”开头，后跟用于基元类型的单字符代码，以及后跟对象数组的数组中包含的元素类型的L。
 * 多维数组为每个维度添加一个“[”
 * 输出结果：
 * char数组的class信息 ac.getClass() = class [C
 * ac.getClass().getSuperclass() = class java.lang.Object
 * int数组的class信息 ia.getClass() = class [I
 * long数组的class信息 la.getClass() = class [J
 * double数组的class信息 da.getClass() = class [D
 * String数组的class信息 sa.getClass() = class [Ljava.lang.String;
 * E10_PrimitiveOrTrue类型数组的class信息 pot.getClass() = class [Ltypeinfo.exercise.E10_PrimitiveOrTrue;
 * 三维数组的class信息 threed.getClass() = class [[[I
 * </pre>
 * created at 2019-08-15 12:46
 * @author lerry
 */
public class E10_PrimitiveOrTrue {

	public static void main(String args[]) {
		char[] ac = "Hello, World!".toCharArray();
		print("char数组的class信息 ac.getClass() = " + ac.getClass());
		printlnf("数组是对象吗？ ac instanceof Object : %s", (ac instanceof Object));
		print("ac.getClass().getSuperclass() = "
				+ ac.getClass().getSuperclass());
		char c = 'c';
		//! c.getClass(); // Can't do it, primitives
		// are not true objects.
		int[] ia = new int[3];
		print("int数组的class信息 ia.getClass() = " + ia.getClass());
		long[] la = new long[3];
		print("long数组的class信息 la.getClass() = " + la.getClass());
		double[] da = new double[3];
		print("double数组的class信息 da.getClass() = " + da.getClass());
		String[] sa = new String[3];
		print("String数组的class信息 sa.getClass() = " + sa.getClass());
		E10_PrimitiveOrTrue[] pot = new E10_PrimitiveOrTrue[3];
		print("E10_PrimitiveOrTrue类型数组的class信息 pot.getClass() = " + pot.getClass());
		// Multi-dimensional arrays:
		int[][][] threed = new int[3][][];
		print("三维数组的class信息 threed.getClass() = " + threed.getClass());
	}

}
