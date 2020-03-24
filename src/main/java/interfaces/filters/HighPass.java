//: interfaces/filters/HighPass.java
package interfaces.filters;

/**
 * HighPass（高通滤波）
 * created at 2020-03-24 08:56
 * @author lerry
 */
public class HighPass extends Filter {
	double cutoff;

	public HighPass(double cutoff) {
		this.cutoff = cutoff;
	}

	@Override
	public Waveform process(Waveform input) {
		return input;
	}
} ///:~
