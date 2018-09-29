package holding.exercise;

import static net.mindview.util.Print.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import net.mindview.util.TextFile;

/**
 * 追踪每个元音字母的数量
 * created at 2018-09-29 17:15
 * @author lerry
 */
public class E20_VowelsInfo {

	/**
	 * 元音字母的Set集合
	 */
	private final static Set<Character> vowels =
			new HashSet<Character>(Arrays.asList('a', 'e', 'o', 'u',
					'i', 'A', 'E', 'O', 'U', 'I'));

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
		TextFile textFile = new TextFile("src/main/java/holding/exercise/E20_VowelsInfo.java", "\\W+");

		// 处理每一个单词
		for (String word : textFile) {
			wordVowels = 0;
			// 对单词中的每一个字母进行判断
			for (char letter : word.toCharArray()) {
				if (vowels.contains(letter)) {
					wordVowels++;

					// 累加每个元音字母出现的次数
					Integer allVowelsCount = everyVowelMap.get(letter);
					if (allVowelsCount == null) {
						everyVowelMap.put(letter, 1);
					}
					else {
						everyVowelMap.put(letter, ++allVowelsCount);
					}
				}// end if
			}
			if (!processedWords.contains(word)) {
				processedWords.add(word);
				printlnf("[%s] has %d vowel(s)", word, wordVowels);
			}
			fileVowels += wordVowels;
		}// end for
		print("Total number of vowels in file: " + fileVowels);
		printlnf("每个元音字母出现的次数统计为：%s", everyVowelMap);
	}
}
