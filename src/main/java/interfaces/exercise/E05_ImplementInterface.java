package interfaces.exercise;

import static net.mindview.util.Print.print;

import interfaces.exercise.ownpackage.AnInterface;

class ImplementInterface implements AnInterface {
	@Override
	public void f() {
		print("ImplementInterface.f");
	}

	@Override
	public void g() {
		print("ImplementInterface.g");
	}

	@Override
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