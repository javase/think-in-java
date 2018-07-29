package polymorphism.exercise;

import static net.mindview.util.Print.print;

import polymorphism.music.Note;

/**
 * Created by limenghua on 2017/10/29.
 * @author limenghua
 */
public class E06_MusicToString {
	static Instrument[] orchestra = {
			new Wind(),
			new Percussion(),
			new Stringed(),
			new Brass(),
			new Woodwind()
	};

	public static void printAll(Instrument[] orch) {
		for (Instrument i : orch) {
			print(i);
		}
	}

	public static void main(String args[]) {
		printAll(orchestra);
	}
}

class Instrument {
	void play(Note n) {
		print("Instrument.play() " + n);
	}

	@Override
	public String toString() {
		return "Instrument";
	}

	void adjust() {
	}
}

class Wind extends Instrument {
	@Override
	void play(Note n) {
		print("Wind.play() " + n);
	}

	@Override
	public String toString() {
		return "Wind";
	}
}

class Percussion extends Instrument {
	@Override
	void play(Note n) {
		print("Percussion.play() " + n);
	}

	@Override
	public String toString() {
		return "Percussion";
	}
}

class Stringed extends Instrument {
	@Override
	void play(Note n) {
		print("Stringed.play() " + n);
	}

	@Override
	public String toString() {
		return "Stringed";
	}
}

class Brass extends Wind {
	@Override
	void play(Note n) {
		print("Brass.play() " + n);
	}

	@Override
	void adjust() {
		print("Brass.adjust()");
	}
}

class Woodwind extends Wind {
	@Override
	void play(Note n) {
		print("Woodwind.play() " + n);
	}

	@Override
	public String toString() {
		return "Woodwind";
	}
}
