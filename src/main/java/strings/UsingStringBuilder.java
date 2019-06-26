package strings;//: strings/UsingStringBuilder.java

import java.util.Random;

public class UsingStringBuilder {
	public static Random rand = new Random(47);

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("[");
		for (int i = 0; i < 25; i++) {
			result.append(rand.nextInt(100));
			result.append(", ");
		}
		// 删除StringBuilder最后一个逗号和空格
		result.delete(result.length() - 2, result.length());
		result.append("]");
		return result.toString();
	}

	public static void main(String[] args) {
		UsingStringBuilder usb = new UsingStringBuilder();
		System.out.println(usb);
	}
} /* Output:
[58, 55, 93, 61, 61, 29, 68, 0, 22, 7, 88, 28, 51, 89, 9, 78, 98, 61, 20, 58, 16, 40, 11, 22, 4]
*///:~
