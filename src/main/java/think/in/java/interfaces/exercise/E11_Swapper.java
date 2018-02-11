package think.in.java.interfaces.exercise;

import think.in.java.interfaces.interfaceprocessor.Apply;
import think.in.java.interfaces.interfaceprocessor.Processor;

/**
 * Created by limenghua on 2017/11/2.
 * @author limenghua
 */
class CharacterPairSwapper {
	// 接收String类型的参数
	static String swap(String s) {
		StringBuilder sb = new StringBuilder(s);
		for (int i = 0; i < sb.length() - 1; i += 2) {
			char c1 = sb.charAt(i);
			char c2 = sb.charAt(i + 1);
			sb.setCharAt(i, c2);
			sb.setCharAt(i + 1, c1);
		}
		return sb.toString();
	}
}

class SwapperAdapter implements Processor {
	public String name() {
		return CharacterPairSwapper.class.getSimpleName();
	}

	public String process(Object input) {
		return CharacterPairSwapper.swap((String) input);
	}
}

public class E11_Swapper {
	public static void main(String[] args) {
		Apply.process(new SwapperAdapter(), "1234");
		Apply.process(new SwapperAdapter(), "abcde");
	}
}