package holding;//: holding/PrintingContainers.java
// Containers print themselves automatically.

import java.util.*;

import static net.mindview.util.Print.*;

public class PrintingContainers {
	static Collection fill(Collection<String> collection) {
		collection.add("rat");
		collection.add("cat");
		collection.add("dog");
		collection.add("dog");
		collection.add("apple");
		return collection;
	}

	static Map fill(Map<String, String> map) {
		map.put("rat", "Fuzzy");
		map.put("cat", "Rags");
		map.put("dog", "Bosco");
		map.put("dog", "Spot");
		map.put("apple", "Apple");
		return map;
	}

	public static void main(String[] args) {
		print("ArrayList:" + fill(new ArrayList<String>()));
		print("LinkedList:" + fill(new LinkedList<String>()));
		print("HashSet:" + fill(new HashSet<String>()));
		print("TreeSet(按照字母顺序排列):" + fill(new TreeSet<String>()));
		print("LinkedHashSet(按照插入顺序保存对象):" + fill(new LinkedHashSet<String>()));
		print("HashMap:" + fill(new HashMap<String, String>()));
		print("TreeMap(按照字母顺序排列):" + fill(new TreeMap<String, String>()));
		print("LinkedHashMap（按照插入顺序保存键）:" + fill(new LinkedHashMap<String, String>()));
	}
} /* Output:
[rat, cat, dog, dog]
[rat, cat, dog, dog]
[dog, cat, rat]
[cat, dog, rat]
[rat, cat, dog]
{dog=Spot, cat=Rags, rat=Fuzzy}
{cat=Rags, dog=Spot, rat=Fuzzy}
{rat=Fuzzy, cat=Rags, dog=Spot}
*///:~
