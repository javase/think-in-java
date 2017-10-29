//: polymorphism/music/Music2.java
// Overloading instead of upcasting.
package think.in.java.polymorphism.music;

import static net.mindview.util.Print.*;

/**
 * 如果新加了Instrument类型
 */
class Stringed extends Instrument {
	@Override
	public void play(Note n) {
		print("Stringed.play() " + n);
	}
}

class Brass extends Instrument {
	@Override
	public void play(Note n) {
		print("Brass.play() " + n);
	}
}

/**
 * 不适用多台，则tune()方法的参数，需要制定到具体类型
 */
public class Music2 {

	public static void tune(Wind i) {
		i.play(Note.MIDDLE_C);
	}

	public static void tune(Stringed i) {
		i.play(Note.MIDDLE_C);
	}

	public static void tune(Brass i) {
		i.play(Note.MIDDLE_C);
	}

	public static void main(String[] args) {
		Wind flute = new Wind();
		Stringed violin = new Stringed();
		Brass frenchHorn = new Brass();
		tune(flute); // No upcasting
		tune(violin);
		tune(frenchHorn);
	}
} /* Output:
Wind.play() MIDDLE_C
Stringed.play() MIDDLE_C
Brass.play() MIDDLE_C
*///:~
