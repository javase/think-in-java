package think.in.java.holding.exercise;

import java.util.*;

import static net.mindview.util.Print.*;

class MovieNameGenerator {
	String[] characters = {
			"Grumpy", "Happy", "Sleepy", "Dopey", "Doc", "Sneezy",
			"Bashful", "Snow White", "Witch Queen", "Prince"
	};

	int next;

	public String next() {
		String r = characters[next];
		print(next + 1);
		// 字符列表中的字符用完之后，循环到这个字符列表的开始处
		next = (next + 1) % characters.length;
		return r;
	}
}

public class E04_MovieNameGenerator {

	private static final MovieNameGenerator mng =
			new MovieNameGenerator();

	static String[] fill(String[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = mng.next();
		}
		return array;
	}

	static Collection<String> fill(Collection<String> collection) {
		for (int i = 0; i < 5; i++) {
			collection.add(mng.next());
		}
		return collection;
	}

	public static void main(String[] args) {
		String str = Arrays.toString(fill(new String[5]));
		print("String数组fill：" + str);
		print(fill(new ArrayList<String>()));
		print(fill(new LinkedList<String>()));
		print(fill(new HashSet<String>()));
		print(fill(new LinkedHashSet<String>()));
		print(fill(new TreeSet<String>()));
	}
}