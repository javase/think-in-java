//: interfaces/filters/BandPass.java
package interfaces.filters;
/**
 * BandPass ： n. [电子] 带通，通频带
 * created at 2020-03-24 08:56
 * @author lerry
 */
public class BandPass extends Filter {
	double lowCutoff, highCutoff;

	public BandPass(double lowCut, double highCut) {
		lowCutoff = lowCut;
		highCutoff = highCut;
	}

	@Override
	public Waveform process(Waveform input) {
		return input;
	}
} ///:~
