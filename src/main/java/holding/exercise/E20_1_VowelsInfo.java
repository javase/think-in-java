package holding.exercise;

import static net.mindview.util.Print.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import net.mindview.util.TextFile;

/**
 * 追踪每个元音字母的数量  改进：提取公用的更新map中value数量的方法
 * created at 2018-09-29 17:15
 * @author lerry
 */
public class E20_1_VowelsInfo {

	/**
	 * 元音字母的Set集合
	 */
	private final static Set<Character> vowels =
			new HashSet<Character>(Arrays.asList('a', 'e', 'o', 'u',
					'i', 'A', 'E', 'O', 'U', 'I'));

	/**
	 * 如果存在key，则累加1；否则，新加如改字符，并初始化为1
	 * @param map
	 * @param letter
	 */
	static void updateMapState(Map<Character, Integer> map, char letter) {
		// 累加每个元音字母出现的次数
		Integer integer = map.get(letter);
		if (integer == null) {
			map.put(letter, 1);
		}
		else {
			map.put(letter, ++integer);
		}
	}

	public static void main(String[] args) {
		HashMap<Character, Integer> everyVowelMap = new HashMap<>();

		HashSet<String> processedWords = new HashSet<String>();

		/**
		 * 文件中元音字母的总数量
		 */
		int fileVowels = 0;
		/**
		 * 单词中元音字母的数量
		 */
		int wordVowels;

		// 所有单词的集合
		TextFile textFile = new TextFile("src/main/java/holding/exercise/E20_1_VowelsInfo.java", "\\W+");

		HashMap<Character, Integer> eachInWord = null;
		// 处理每一个单词
		for (String word : textFile) {
			wordVowels = 0;

			// 用于统计每个单词中，元音字母出现的个数
			eachInWord = new HashMap<>();

			// 对单词中的每一个字母进行判断
			for (char letter : word.toCharArray()) {
				if (vowels.contains(letter)) {
					wordVowels++;

					// 累加每个元音字母出现的次数
					updateMapState(everyVowelMap, letter);

					updateMapState(eachInWord, letter);

				}// end if
			}// end for
			if (!processedWords.contains(word)) {
				processedWords.add(word);
				printlnf("[%s] has %d vowel(s) : %s", word, wordVowels, eachInWord);
			}
			fileVowels += wordVowels;
		}// end for
		print("Total number of vowels in file: " + fileVowels);
		printlnf("每个元音字母出现的次数统计为：%s", everyVowelMap);
	}
}
