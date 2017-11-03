//: interfaces/interfaceprocessor/FilterProcessor.java
package think.in.java.interfaces.interfaceprocessor;


import think.in.java.interfaces.filters.BandPass;
import think.in.java.interfaces.filters.Filter;
import think.in.java.interfaces.filters.HighPass;
import think.in.java.interfaces.filters.LowPass;
import think.in.java.interfaces.filters.Waveform;

/**
 * 适配器对象实现原有接口
 */
class FilterAdapter implements Processor {
	// 适配器对象组合一个实现新接口的对象
	// （这个对象也可以不实现一个接口，只是一个单纯的对象）
	// 在这里，filter就是一个单纯的对象
	Filter filter;

	public FilterAdapter(Filter filter) {
		this.filter = filter;
	}

	public String name() {
		return filter.name();
	}

	/**
	 * 对适配器原有接口方法的调用被委托给新接口的实例的特定方法
	 * @param input
	 * @return
	 */
	public Waveform process(Object input) {
		Waveform waveform = filter.process((Waveform) input);
		return waveform;
	}
}

public class FilterProcessor {
	public static void main(String[] args) {
		Waveform w = new Waveform();
		// 通过适配器的转换，可以将Filter对象用于Apply.process方法
		Filter filter = new LowPass(1.0);
		FilterAdapter adapter = new FilterAdapter(filter);
		Apply.process(adapter, w);

		Apply.process(new FilterAdapter(new HighPass(2.0)), w);
		Apply.process(
				new FilterAdapter(new BandPass(3.0, 4.0)), w);
	}
} /* Output:
Using Processor LowPass
Waveform 0
Using Processor HighPass
Waveform 0
Using Processor BandPass
Waveform 0
*///:~
