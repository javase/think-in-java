package holding.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import net.mindview.util.TextFile;

/**
 * 记录此java文件中，一个单词出现的位置
 */
public class E25_WordsInfo3 {
	public static void main(String[] args) {
		Map<String, ArrayList<Integer>> stat = new HashMap<>();
		int wordCount = 0;
		for (String word :
				new TextFile("src/main/java/holding/exercise/E25_WordsInfo3.java", "\\W+")) {
			ArrayList<Integer> loc = stat.get(word);
			if (loc == null) {
				loc = new ArrayList<>();
				stat.put(word, loc);
			}
			loc.add(++wordCount);
		}
		System.out.println(stat);
	}
}