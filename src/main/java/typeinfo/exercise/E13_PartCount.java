package typeinfo.exercise;

import static net.mindview.util.Print.*;

import net.mindview.util.TypeCounter;
import typeinfo.Part;

/**
 * created at 2019-08-22 13:01
 * @author lerry
 */
public class E13_PartCount {
	public static void main(String[] args) {
		TypeCounter counter = new TypeCounter(Part.class);
		Part part;
		for (int i = 0; i < 20; i++) {
			part = Part.createRandom();
			printnb(part.getClass().getSimpleName() + " ");
			counter.count(part);
		}
		printlnf("");
		printALine();
		printlnf("counter:\n%s", counter);
	}
}
