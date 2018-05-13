//: interfaces/filters/Waveform.java
package think.in.java.interfaces.filters;

public class Waveform {
	private static long counter;

	private final long id = counter++;

	@Override
	public String toString() {
		return String.format("Waveform id:%d", id);
	}
} ///:~
