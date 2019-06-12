package excptions;//: exceptions/TurnOffChecking.java
// "Turning off" Checked exceptions.

import static net.mindview.util.Print.*;

import java.io.FileNotFoundException;
import java.io.IOException;

class WrapCheckedException {
	/**
	 * 该方法，可以生成不同类型的异常
	 * @param type
	 */
	void throwRuntimeException(int type) {
		try {
			switch (type) {
				case 0:
					throw new FileNotFoundException();
				case 1:
					throw new IOException();
				case 2:
					throw new RuntimeException("Where am I?");
				default:
					return;
			}
		}
		catch (Exception e) { // Adapt to unchecked:
			// 转成不检查的异常、运行时异常
			throw new RuntimeException(e);
		}
	}
}

class SomeOtherException extends Exception {
}

/**
 * 将受检查的异常，转为运行时异常。然后再使用getCause()，获取受检查的异常。
 */
public class TurnOffChecking {
	public static void main(String[] args) {
		WrapCheckedException wce = new WrapCheckedException();
		// You can call throwRuntimeException() without a try
		// block, and let RuntimeExceptions leave the method:
		wce.throwRuntimeException(3);
		// Or you can choose to catch exceptions:
		for (int i = 0; i < 4; i++) {
			try {
				if (i < 3) {
					wce.throwRuntimeException(i);
				}
				else {
					throw new SomeOtherException();
				}
			}
			catch (SomeOtherException e) {
				print("SomeOtherException: " + e);
			}
			catch (RuntimeException re) {
				// 可以提取原先的异常
				try {
					// 捕获并处理特定的异常
					throw re.getCause();
				}
				catch (FileNotFoundException e) {
					print("FileNotFoundException: " + e);
				}
				catch (IOException e) {
					print("IOException: " + e);
				}
				catch (Throwable e) {
					print("Throwable: " + e);
				}
			}
		}
	}
} /* Output:
FileNotFoundException: java.io.FileNotFoundException
IOException: java.io.IOException
Throwable: java.lang.RuntimeException: Where am I?
SomeOtherException: SomeOtherException
*///:~
