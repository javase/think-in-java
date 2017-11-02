package think.in.java.interfaces.exercise;

import static net.mindview.util.Print.print;

import think.in.java.interfaces.exercise.ownpackage.AnInterface;

class ImplementInterface implements AnInterface {
	public void f() {
		print("ImplementInterface.f");
	}

	public void g() {
		print("ImplementInterface.g");
	}

	public void h() {
		print("ImplementInterface.h");
	}
}

public class E05_ImplementInterface {
	public static void main(String args[]) {
		ImplementInterface imp = new ImplementInterface();
		imp.f();
		imp.g();
		imp.h();
	}
}