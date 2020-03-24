package generics;//: generics/RandomList.java

import java.util.ArrayList;
import java.util.Random;

/**
 * 15.2.3 RandomList
 * 该类持有一个ArrayList类型的属性，可以随机生成指定类型的对象
 * created at 2020-03-24 08:24
 * @author lerry
 */
public class RandomList<T> {
	private ArrayList<T> storage = new ArrayList<T>();

	private Random rand = new Random(47);

	public void add(T item) {
		storage.add(item);
	}

	public T select() {
		return storage.get(rand.nextInt(storage.size()));
	}

	public static void main(String[] args) {
		RandomList<String> rs = new RandomList<String>();
		for (String s : ("The quick brown fox jumped over " +
				"the lazy brown dog").split(" ")) {
			rs.add(s);
		}
		for (int i = 0; i < 11; i++) {
			System.out.print(rs.select() + " ");
		}
	}
} /* Output:
brown over fox quick quick dog brown The brown lazy brown
*///:~
