package holding;//: holding/UniqueWords.java

import java.util.*;

import net.mindview.util.*;

/**
 * 把文件中的单词，按照字典顺序打印出来(大、小写字母在不同组中)
 */
public class UniqueWords {

	private static String filePath = "src/main/java/holding/SetOperations.java";

	public static void main(String[] args) {
		Set<String> words = new TreeSet<String>(new TextFile(filePath, "\\W+"));
		System.out.println(words);
	}
} /* Output:
[A, B, C, Collections, D, E, F, G, H, HashSet, I, J, K, L, M, N, Output, Print, Set, SetOperations, String, X, Y, Z, add, addAll, added, args, class, contains, containsAll, false, from, holding, import, in, java, main, mindview, net, new, print, public, remove, removeAll, removed, set1, set2, split, static, to, true, util, void]
*///:~
