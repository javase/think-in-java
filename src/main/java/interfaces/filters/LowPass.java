//: interfaces/filters/LowPass.java
package interfaces.filters;

/**
 * LowPass: LowPass（低通滤波）
 * created at 2020-03-24 08:54
 * @author lerry
 */
public class LowPass extends Filter {
	double cutoff;

	public LowPass(double cutoff) {
		this.cutoff = cutoff;
	}

	@Override
	public Waveform process(Waveform input) {
		// Dummy processing
		return input;
	}
} ///:~
