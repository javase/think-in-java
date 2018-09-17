package holding.exercise;

import static net.mindview.util.Print.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class E17_GerbilMap {
	public static void main(String args[]) {
		Map<String, Gerbil> map = new HashMap<String, Gerbil>();
		map.put("Fuzzy", new Gerbil(1));
		map.put("Spot", new Gerbil(2));
		map.put("Joe", new Gerbil(3));
		map.put("Ted", new Gerbil(4));
		map.put("Heather", new Gerbil(5));

		// 为keyset获取iterator，遍历map
		Iterator iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			printlnf("%s:%s", key, map.get(key));
		}

		print("\n");
		// 也可以指定泛型这样写
		Iterator<Map.Entry<String, Gerbil>> gerbilIt = map.entrySet().iterator();
		while (gerbilIt.hasNext()) {
			Map.Entry entry = gerbilIt.next();
			printlnf("%s:%s", entry.getKey(), entry.getValue());
		}

		print("\n");
		// 先获取key的集合，然后进行遍历
		Iterator<String> strIt = map.keySet().iterator();
		while (strIt.hasNext()) {
			String key = strIt.next();
			printlnf("%s:%s", key, map.get(key));
		}

		print("\n只打印值：");
		Collection<Gerbil> gerbils = map.values();
		for (Gerbil gerbil : gerbils) {
			print(gerbil);
		}
	}
} /* Output:
         Ted: gerbil 4 is hopping
         Heather: gerbil 5 is hopping
         Spot: gerbil 2 is hopping
         Joe: gerbil 3 is hopping
         Fuzzy: gerbil 1 is hopping
         *///:~