package think.in.java.interfaces.exercise;

import static net.mindview.util.Print.print;

import think.in.java.polymorphism.music.Note;

/**
 * Created by limenghua on 2017/11/2.
 * @author limenghua
 */
interface Instrument2 {
	void adjust();
}

/**
 * 使用接口来规范演奏方法
 */
interface Playable {
	void play(Note n);
}

class Wind2 implements Instrument2, Playable {
	@Override
	public void play(Note n) {
		print(this + ".play() " + n);
	}

	@Override
	public String toString() {
		return "Wind";
	}

	@Override
	public void adjust() {
		print(this + ".adjust()");
	}
}

class Percussion2 implements Instrument2, Playable {
	@Override
	public void play(Note n) {
		print(this + ".play() " + n);
	}

	@Override
	public String toString() {
		return "Percussion";
	}

	@Override
	public void adjust() {
		print(this + ".adjust()");
	}
}

class Stringed2 implements Instrument2, Playable {
	@Override
	public void play(Note n) {
		print(this + ".play() " + n);
	}

	@Override
	public String toString() {
		return "Stringed";
	}

	@Override
	public void adjust() {
		print(this + ".adjust()");
	}
}

class Brass2 extends Wind2 {
	@Override
	public String toString() {
		return "Brass";
	}
}

class Woodwind2 extends Wind2 {
	@Override
	public String toString() {
		return "Woodwind";
	}
}

public class E10_PlayableMusic5 {
	// 接收接口类型的参数
	static void tune(Playable p) {
		p.play(Note.MIDDLE_C);
	}

	static void tuneAll(Playable[] e) {
		for (Playable p : e) {
			tune(p);
		}
	}

	public static void main(String[] args) {
		Playable[] orchestra = {
				new Wind2(),
				new Percussion2(),
				new Stringed2(),
				new Brass2(),
				new Woodwind2()
		};
		tuneAll(orchestra);
	}
}
