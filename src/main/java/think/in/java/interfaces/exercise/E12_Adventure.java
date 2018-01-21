package think.in.java.interfaces.exercise;

import static net.mindview.util.Print.print;

/**
 * Created by limenghua on 2018/1/20.
 * @author limenghua
 */

interface CanFight {
	void fight();
}

interface CanSwim {
	void swim();
}

interface CanFly {
	void fly();
}

interface CanClimb {
	void climb();
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
		implements CanFight, CanSwim, CanFly, CanClimb {
	public void swim() {
		print("sub class swim method");

	}

	public void fly() {
		print("sub class fly method");
	}

	public void climb() {

	}

//	@Override
//	public void fight() {
//		print("sub class fight method");
//	}
}

public class E12_Adventure {
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

	public static void c(CanClimb x) {
		x.climb();
	}

	public static void main(String[] args) {
		Hero h = new Hero();
		t(h); // Treat it as a CanFight
		u(h); // Treat it as a CanSwim
		v(h); // Treat it as a CanFly
		c(h);  // 可以爬
		w(h); // Treat it as an ActionCharacter
	}
} ///:~
