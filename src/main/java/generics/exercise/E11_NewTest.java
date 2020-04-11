package generics.exercise;

import java.util.List;
import java.util.Set;

import net.mindview.util.New;

/**
 * 15.4.1 杠杆利用类型参数推断
 * 练习11: (1) 创建自己的若干个类来测试New.java,并确保New可以正确地与它们一起工作。
 * created at 2020-04-11 16:56
 * @author lerry
 */
public class E11_NewTest {
	public static void main(String[] args) {
		List<SixTuple<Byte, Short, String, Float, Double, Integer>> list = New.list();
		list.add(
				new SixTuple<Byte, Short, String, Float, Double, Integer>(
						(byte) 1, (short) 1, "A", 1.0F, 1.0, 1));
		System.out.println(list);
		Set<Sequence<String>> set = New.set();
		set.add(new Sequence<String>(5));
		System.out.println(set);
	}
} /* Output: (Sample)
         [(1, 1, A, 1.0, 1.0, 1)]
         [Sequence@3e25a5]
         *///:~