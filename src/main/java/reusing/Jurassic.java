package reusing;//: reusing/Jurassic.java
// Making an entire class final.

class SmallBrain {
}

final class Dinosaur {
	int i = 7;

	int j = 1;

	SmallBrain x = new SmallBrain();

	void f() {
	}
}

// 不可以继承 final 类
//! class Further extends Dinosaur {}
// error: Cannot extend final class 'Dinosaur'

public class Jurassic {
	public static void main(String[] args) {
		Dinosaur n = new Dinosaur();
		n.f();
		n.i = 40; // final类中的域可以不是final的
		n.j++;
	}
} ///:~
