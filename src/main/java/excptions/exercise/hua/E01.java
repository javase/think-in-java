package excptions.exercise.hua;

import net.mindview.util.Print;

/**
 * created at 2019-06-04 12:28
 * @author lerry
 */
public class E01 {
	public static void main(String[] args) {
		try {
			int a = 1 / 0;
		}
		catch (Exception e) {
			Print.printlnf(e.getMessage());
		}finally {
			Print.printlnf("here is finally");
		}
	}
}
