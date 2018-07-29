package polymorphism.exercise;

import static net.mindview.util.Print.print;

class InstrumentGenerator {
	java.util.Random gen = new java.util.Random(47);

	public Instrument next() {
		switch (gen.nextInt(6)) {
			default:
			case 0:
				return new Wind();
			case 1:
				return new Percussion();
			case 2:
				return new Stringed();
			case 3:
				return new Brass();
			case 4:
				return new Woodwind();
			case 5:
				return new Electronic();
		}
	}
}

/**
 * 随机创建Instrument对象
 */
public class E08_RandomInstruments {
	public static void main(String args[]) {
		InstrumentGenerator gen = new InstrumentGenerator();
		for (int i = 0; i < 20; i++) {
			print(gen.next());
		}
	}
}