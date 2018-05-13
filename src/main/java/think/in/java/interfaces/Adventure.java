package think.in.java.interfaces;//: interfaces/Adventure.java
// Multiple interfaces.

import static net.mindview.util.Print.print;

interface CanFight {
	void fight();
}

interface CanSwim {
	void swim();
}

interface CanFly {
	void fly();
}

class ActionCharacter {
	public void fight() {
		print("base class fight method");
	}
}

/**
 * 继承一个类、多个接口
 */
class Hero extends ActionCharacter
		implements CanFight, CanSwim, CanFly {
	@Override
	public void swim() {
		print("sub class swim method");

	}

	@Override
	public void fly() {
		print("sub class fly method");
	}

//	@Override
//	public void fight() {
//		print("sub class fight method");
//	}
}

public class Adventure {
	public static void t(CanFight x) {
		// Hero 没有重写父类的fight方法，则调用父类的fight方法
		x.fight();
	}

	public static void u(CanSwim x) {
		x.swim();
	}

	public static void v(CanFly x) {
		x.fly();
	}

	public static void w(ActionCharacter x) {
		// Hero 没有重写父类的fight方法，则调用父类的fight方法
		x.fight();
	}

	public static void main(String[] args) {
		Hero h = new Hero();
		t(h); // Treat it as a CanFight
		u(h); // Treat it as a CanSwim
		v(h); // Treat it as a CanFly
		w(h); // Treat it as an ActionCharacter
	}
} ///:~
