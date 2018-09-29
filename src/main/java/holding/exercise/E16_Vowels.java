package holding.exercise;

import java.util.*;

import net.mindview.util.*;

import static net.mindview.util.Print.*;

/**
 * 计数并显示每一个输入单词（当前文件）中元音字母的数量
 */
public class E16_Vowels {
	/**
	 * 元音字母的Set集合
	 */
	private final static Set<Character> vowels =
			new HashSet<Character>(Arrays.asList('a', 'e', 'o', 'u',
					'i', 'A', 'E', 'O', 'U', 'I'));

	public static void main(String[] args) {
		HashSet<String> processedWords = new HashSet<String>();

		/**
		 * 文件中元音字母的总数量
		 */
		int fileVowels = 0;
		/**
		 * 单词中元音字母的数量
		 */
		int wordVowels;

		TextFile textFile = new TextFile("src/main/java/holding/exercise/E16_Vowels.java", "\\W+");
		for (String word : textFile) {
			wordVowels = 0;
			// 对单词中的每一个字母进行判断
			for (char letter : word.toCharArray()) {
				if (vowels.contains(letter)) {
					wordVowels++;
				}
			}
			if (!processedWords.contains(word)) {
				processedWords.add(word);
				printlnf("[%s] has %d vowel(s)", word, wordVowels);
			}
			fileVowels += wordVowels;
		}// end for
		print("Total number of vowels in file: " + fileVowels);
	}
} /* Output: (Sample)
         holding has 2 vowel(s)
         E16_Vowels has 3 vowel(s)
         java has 2 vowel(s)
         Exercise has 4 vowel(s)
         16 has 0 vowel(s)
         Create has 3 vowel(s)
         ...
         contains has 3 vowel(s)
         add has 1 vowel(s)
         print has 1 vowel(s)
         has has 1 vowel(s)
         vowel has 2 vowel(s)
         s has 0 vowel(s)
         Total has 2 vowel(s)
         Total number of vowels in file: 240
         *///:~