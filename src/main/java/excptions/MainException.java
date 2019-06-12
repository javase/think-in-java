package excptions;//: exceptions/MainException.java

import java.io.FileInputStream;

/**
 * main作为一个方法，也可以有异常说明
 */
public class MainException {
	// Pass all exceptions to the console:
	public static void main(String[] args) throws Exception {
		// Open the file:
		FileInputStream file =
				new FileInputStream("MainException.java");
		// Use the file ...
		// Close the file:
		file.close();
	}
} ///:~
