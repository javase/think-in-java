package excptions.exercise;

/**
 * <pre>
 *     throw new Exception("An exception in main");
 *     和e.getMessage()，都是操作的Throwable.detailMessage字符串对象
 * </pre>
 */
public class E01_SimpleException {
	public static void main(String args[]) {
		try {
			throw new Exception("An exception in main");
		}
		catch (Exception e) {
			System.out.println(
					"e.getMessage() = " + e.getMessage());
		}
		finally {
			System.out.println("In finally clause");
		}
	}
}