package excptions.exercise;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * 将异常栈也打印到日志中
 * e.printStackTrace(new PrintWriter(trace)); 追踪异常栈
 */
public class E07_LoggedArrayIndexBounds {
	private static Logger logger =
			Logger.getLogger("E07_LoggedArrayIndexBounds");

	static void logException(Exception e) {
		StringWriter trace = new StringWriter();
		e.printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	}

	public static void main(String args[]) {
		char[] array = new char[10];
		try {
			array[10] = 'x';
		}
		catch (ArrayIndexOutOfBoundsException e) {
			logException(e);
		}
	}
}