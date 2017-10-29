package think.in.java.polymorphism.exercise;

import static net.mindview.util.Print.print;

import think.in.java.polymorphism.music.Note;

public class Electronic extends Instrument {
	void play(Note n) {
		print("Electronic.play() " + n);
	}

	public String toString() {
		return "Electronic";
	}
}