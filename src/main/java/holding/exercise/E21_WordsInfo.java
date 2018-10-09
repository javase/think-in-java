package holding.exercise;

import static net.mindview.util.Print.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.mindview.util.TextFile;

/**
 * 对一个文件中单词出现的次数统计，并把这些单词按照字母顺序排列
 * created at 2018-10-08 16:10
 * @author lerry
 */
public class E21_WordsInfo {
	public static void main(String[] args) {
		Map<String, Integer> wordFreq = new HashMap<>();

		for (String word : new TextFile("src/main/java/holding/exercise/E21_WordsInfo.java", "\\W+")) {
			Integer freq = wordFreq.get(word);
			wordFreq.put(word, freq == null ? 1 : wordFreq.get(word) + 1);
		}

		List<String> sortList = new ArrayList<>(wordFreq.keySet());
		Collections.sort(sortList, String.CASE_INSENSITIVE_ORDER);
		for (String word : sortList) {
			printlnf("[%s] = %d", word, wordFreq.get(word));
		}

	}
}
