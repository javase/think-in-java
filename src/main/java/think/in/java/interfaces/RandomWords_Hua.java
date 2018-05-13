package think.in.java.interfaces;//: interfaces/RandomWords.java
// Implementing an interface to conform to a method.

import java.nio.CharBuffer;
import java.util.Scanner;

public class RandomWords_Hua implements Readable {

	private int count;

	public RandomWords_Hua(int count) {
		this.count = count;
	}

	@Override
	public int read(CharBuffer cb) {
		if (--count < 0) {
			// -1 表示该输入资源结束
			return -1;
		}
		cb.append("这");
		cb.append("儿");
		cb.append("随");
		cb.append("便");
		cb.append("写");
		cb.append(" ");
		// 0 不对字符进行缓存
		return 0;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(new RandomWords_Hua(10));
		int count = 0;
		while (s.hasNext()) {
			System.out.println(String.format("第%s个随机数：%s", ++count, s.next()));
		}
	}
}
