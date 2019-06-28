package strings.exercise;

import java.util.Arrays;

import strings.Splitting;

/**
 * 将Splitting.knights在the和you处分隔
 */
public class E08_Splitting2 {
	public static void split(String regex) {
		System.out.println(
				Arrays.toString(Splitting.knights.split(regex)));
	}

	public static void main(String[] args) {
		split("the|you");
	}
} /* Output:
         [Then, when ,  have found ,  shrubbery, ,  must cut down ,
         mightiest tree in ,  forest... with... a herring!]
         *///:~
