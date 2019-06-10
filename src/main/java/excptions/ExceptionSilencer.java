package excptions;//: exceptions/ExceptionSilencer.java

/**
 * 即使抛出了异常，也不会产生任何输出。因为没有catch语句。
 */
public class ExceptionSilencer {
	public static void main(String[] args) {
		try {
			throw new RuntimeException();
		}
		finally {
			// Using 'return' inside the finally block
			// will silence any thrown exception.
			return;
		}
	}
} ///:~
