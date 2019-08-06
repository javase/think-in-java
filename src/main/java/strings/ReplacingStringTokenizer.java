package strings;//: strings/ReplacingStringTokenizer.java

import static net.mindview.util.Print.*;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * jdk5之前，分隔字符串的唯一方法是使用StringTokenizer
 * StringTokenizer已经可以放弃不用了
 */
public class ReplacingStringTokenizer {
	public static void main(String[] args) {
		String input = "But I'm not dead yet! I feel happy!";
		StringTokenizer stoke = new StringTokenizer(input);
		while (stoke.hasMoreElements()) {
			System.out.print(stoke.nextToken() + " ");
		}
		System.out.println();
		printALine();
		System.out.println(Arrays.toString(input.split(" ")));
		Scanner scanner = new Scanner(input);
		while (scanner.hasNext()) {
			System.out.print(scanner.next() + " ");
		}
	}
} /* Output:
But I'm not dead yet! I feel happy!
[But, I'm, not, dead, yet!, I, feel, happy!]
But I'm not dead yet! I feel happy!
*///:~
