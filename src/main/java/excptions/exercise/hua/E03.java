package excptions.exercise.hua;

import net.mindview.util.Print;

/**
 * created at 2019-06-04 12:39
 * @author lerry
 */
public class E03 {
	public static void main(String[] args) {
		String[] arrays = {"1", "2"};
		try {
			Print.printlnf(args[2]);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			Print.printlnf("e = %s", e);
		}
	}
}
