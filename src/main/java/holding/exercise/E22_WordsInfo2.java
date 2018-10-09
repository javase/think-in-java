package holding.exercise;


import static net.mindview.util.Print.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.mindview.util.TextFile;

/**
 * 需要可以进行排序
 */
class WordCounter {
	/**
	 * 一个单词  注意：需要是final的，否则该域发生变化时，hashCode也会发生变化
	 */
	private final String word;

	/**
	 * 出现的频率
	 */
	private Integer freq;

	public String getWord() {
		return word;
	}

	public Integer getFreq() {
		return freq;
	}

	public void setFreq(Integer freq) {
		this.freq = freq;
	}

	public WordCounter(String word, Integer freq) {
		this.word = word;
		this.freq = freq;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof WordCounter && this.word.equals(((WordCounter) obj).getWord())) {
			return true;
		}
		else {
			return false;
		}
	}

	public void increase() {
		this.freq++;
	}

	@Override
	public int hashCode() {
		int hashCode = this.word.hashCode();
		return hashCode;
	}
}

/**
 * 使用类来对单词以及出现的频率进行存储，使用set存储这类对象
 * Set中的contains方法，判断是否包含，需要重写hashCode方法
 * created at 2018-10-08 16:39
 * @author lerry
 */
public class E22_WordsInfo2 {

	public static void main(String[] args) {
		Set<WordCounter> wordCounterSet = new HashSet<>();

		for (String word : new TextFile("src/main/java/holding/exercise/E22_WordsInfo2.java", "\\W+")) {

			WordCounter newWordCounter = new WordCounter(word, 1);

			/**
			 * 在判断是否包含时，会用到对象的hashCode()方法
			 */
			if (wordCounterSet.contains(newWordCounter)) {
				// 拿到已存在的对象
				for (WordCounter wordCounter1 : wordCounterSet) {
					if (wordCounter1.equals(newWordCounter)) {
						wordCounter1.increase();
					}
				}
			}
			else {
				wordCounterSet.add(newWordCounter);
			}

		}

		List<WordCounter> wordCounterList = new ArrayList<>(wordCounterSet);
		Collections.sort(wordCounterList, new Comparator<WordCounter>() {
			@Override
			public int compare(WordCounter o1, WordCounter o2) {
				return o1.getWord().compareTo(o2.getWord());
			}
		});

		for (WordCounter wordCounter : wordCounterList) {
			printlnf("[%s] : %d", wordCounter.getWord(), wordCounter.getFreq());
		}
	}
}
