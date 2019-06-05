package excptions.exercise.hua;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

import net.mindview.util.Print;

/**
 * created at 2019-06-04 12:39
 * @author lerry
 */
public class E07 {

	private static final Logger logger = Logger.getLogger("E07");

	public static void main(String[] args) {
		String[] arrays = {"1", "2"};
		try {
			Print.printlnf(args[2]);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			StringWriter traceStringWriter = new StringWriter();
			e.printStackTrace(new PrintWriter(traceStringWriter));
			logger.severe(traceStringWriter.toString());
		}
	}
}
