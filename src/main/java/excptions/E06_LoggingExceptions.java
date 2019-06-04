package excptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

class LoggingException1 extends Exception {
	private static Logger logger =
			Logger.getLogger("LoggingException1");

	public LoggingException1() {
		StringWriter trace = new StringWriter();
		printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	}
}

class LoggingException2 extends Exception {
	private static Logger logger =
			Logger.getLogger("LoggingException2");

	public LoggingException2() {
		StringWriter trace = new StringWriter();
		printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	}
}

/**
 * 每个异常都使用自己的记录器实例，分别是LoggingException1和LoggingException2。
 */
public class E06_LoggingExceptions {
	public static void main(String[] args) {
		System.out.println("----------------------\nLoggingException1:");
		try {
			throw new LoggingException1();
		}
		catch (LoggingException1 e) {
			System.err.println("Caught(err.println) " + e);
//			System.out.println("------------------");
			System.out.println("Caught(out.println) " + e);
		}

		System.out.println("----------------------\nLoggerException2:");
		try {
			throw new LoggingException2();
		}
		catch (LoggingException2 e) {
			System.err.println("Caught " + e);
		}
	}
}