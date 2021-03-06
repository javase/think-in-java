package interfaces.exercise;

import static net.mindview.util.Print.print;

import polymorphism.music.Note;

/**
 * Created by limenghua on 2017/11/2.
 * @author limenghua
 */
abstract class Instrument {
	public void play(Note n) {
		print(this + ".play() " + n);
	}

	public void adjust() {
		print(this + ".adjust()");
	}

	// Forces implementation in derived class:
	@Override
	public abstract String toString();
}

class Wind extends Instrument {
	@Override
	public String toString() {
		return "Wind";
	}
}

class Percussion extends Instrument {
	@Override
	public String toString() {
		return "Percussion";
	}
}

class Stringed extends Instrument {
	@Override
	public String toString() {
		return "Stringed";
	}
}

class Brass extends Wind {
	@Override
	public String toString() {
		return "Brass";
	}
}

class Woodwind extends Wind {
	@Override
	public String toString() {
		return "Woodwind";
	}
}

public class E09_AbstractMusic5 {
	static void tune(Instrument i) {
		i.adjust();
		i.play(Note.MIDDLE_C);
	}

	static void tuneAll(Instrument[] e) {
		for (Instrument i : e) {
			tune(i);
		}
	}

	public static void main(String[] args) {
		Instrument[] orchestra = {
				new Wind(),
				new Percussion(),
				new Stringed(),
				new Brass(),
				new Woodwind()
		};
		tuneAll(orchestra);
	}
}
