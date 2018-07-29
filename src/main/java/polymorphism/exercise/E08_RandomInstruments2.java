package polymorphism.exercise;

import static net.mindview.util.Print.print;

public class E08_RandomInstruments2 {
	public static void main(String args[]) {
		InstrumentGenerator2 gen = new InstrumentGenerator2();
		for (int i = 0; i < 20; i++) {
			print(gen.next());
		}
	}
}