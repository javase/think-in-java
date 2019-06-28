package strings;//: strings/DatabaseException.java

/**
 * String.format示例
 * 底层代码实现为： return new Formatter().format(format, args).toString();
 */
public class DatabaseException extends Exception {

	public DatabaseException(int transactionID, int queryID, String message) {
		super(String.format("(t%d, q%d) %s", transactionID,
				queryID, message));
	}

	public static void main(String[] args) {
		try {
			throw new DatabaseException(3, 7, "Write failed");
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
} /* Output:
DatabaseException: (t3, q7) Write failed
*///:~
