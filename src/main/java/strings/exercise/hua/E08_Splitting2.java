package strings.exercise.hua;

import static net.mindview.util.Print.*;

import java.util.Arrays;

import strings.Splitting;

/**
 * 将Splitting.knights在the和you处分隔
 * created at 2019-06-28 20:23
 * @author lerry
 */
public class E08_Splitting2 {
	public static void main(String[] args) {
		printlnf(Arrays.toString(Splitting.knights.split("the|you")));
	}
}
