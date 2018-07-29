package polymorphism.exercise;

import static net.mindview.util.Print.print;

import polymorphism.music.Note;

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