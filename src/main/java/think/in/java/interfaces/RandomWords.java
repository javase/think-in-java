package think.in.java.interfaces;//: interfaces/RandomWords.java
// Implementing an interface to conform to a method.

import java.nio.*;
import java.util.*;

public class RandomWords implements Readable {
	private static Random rand = new Random(47);

	private static final char[] capitals =
			"ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

	private static final char[] lowers =
			"abcdefghijklmnopqrstuvwxyz".toCharArray();

	private static final char[] vowels =
			"aeiou".toCharArray();

	private int count;

	public RandomWords(int count) {
		this.count = count;
	}

	public int read(CharBuffer cb) {
		if (count-- == 0)
			return -1; // Indicates end of input
		cb.append(capitals[rand.nextInt(capitals.length)]);
		for (int i = 0; i < 1; i++) {
			cb.append(vowels[rand.nextInt(vowels.length)]);
			cb.append(lowers[rand.nextInt(lowers.length)]);
		}
		cb.append(" ");
		return 0; // Number of characters appended
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(new RandomWords(8));
		int count = 0;
		while (s.hasNext()) {
			System.out.println(String.format("第%s个随机数：%s", ++count, s.next()));
		}
	}
} /* Output:
Yazeruyac
Fowenucor
Goeazimom
Raeuuacio
Nuoadesiw
Hageaikux
Ruqicibui
Numasetih
Kuuuuozog
Waqizeyoy
*///:~
