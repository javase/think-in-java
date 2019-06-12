package excptions.exercise;

/**
 * 将异常转变为RuntimeException
 * created at 2019-06-12 12:50
 * @author lerry
 */
public class E27_RuntimeArrayIndexBounds {

	public static void main(String[] args) {
		char[] array = new char[10];
		try {
			array[10] = 'x';
		}
		catch (ArrayIndexOutOfBoundsException e) {
			throw new RuntimeException(e);
		}
	}
}
