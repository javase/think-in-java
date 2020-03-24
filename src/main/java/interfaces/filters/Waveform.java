//: interfaces/filters/Waveform.java
package interfaces.filters;

/**
 * Waveform: n. [物][电子] 波形
 * created at 2020-03-24 08:54
 * @author lerry
 */
public class Waveform {
	private static long counter;

	private final long id = counter++;

	@Override
	public String toString() {
		return String.format("Waveform id:%d", id);
	}
} ///:~
