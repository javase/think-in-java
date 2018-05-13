package think.in.java.polymorphism.exercise;

import static net.mindview.util.Print.print;

import think.in.java.polymorphism.music.Note;

public class Electronic extends Instrument {
	@Override
	void play(Note n) {
		print("Electronic.play() " + n);
	}

	@Override
	public String toString() {
		return "Electronic";
	}
}