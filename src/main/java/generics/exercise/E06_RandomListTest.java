package generics.exercise;

import generics.RandomList;
import net.mindview.util.CountingGenerator;
import net.mindview.util.Generator;

/**
 * 15.2.3 RandomList
 * created at 2020-03-24 08:27
 * @author lerry
 */
public class E06_RandomListTest {

	/**
	 * dump:卸出（数据）；
	 * 注意dump()方法的参数类型：RandomList<？>接受任何用未知类型参数化的RandomList。
	 * @param rl
	 */
	private static void dump(RandomList<?> rl) {
		for (int i = 0; i < 11; i++) {
			System.out.print(rl.select() + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		RandomList<String> rs = new RandomList<String>();
		for (String s : ("The quick brown fox jumped over " +
				"the lazy brown dog").split(" ")) {
			rs.add(s);
		}
		dump(rs);

		// 向RandomList中添加 Integer 类型
		RandomList<Integer> ri = new RandomList<Integer>();
		Generator<Integer> gi =
				new CountingGenerator.Integer();
		for (int i = 0; i < 11; i++) {
			ri.add(gi.next());
		}
		dump(ri);

		// 向RandomList中添加 Character 类型
		RandomList<Character> rc = new RandomList<Character>();
		Generator<Character> gc =
				new CountingGenerator.Character();
		for (int i = 0; i < 11; i++) {
			rc.add(gc.next());
		}
		dump(rc);
	}
} /* Output:
brown over fox quick quick dog brown The brown lazy brown 8 1 9 10 0 0 1 4 5 2 9
ibjkaabefcj
*///:~