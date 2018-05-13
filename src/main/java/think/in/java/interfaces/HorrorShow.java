package think.in.java.interfaces;//: interfaces/HorrorShow.java
// Extending an interface with inheritance.

interface Monster {
	// 威胁；恐吓
	void menace();
}

interface DangerousMonster extends Monster {
	void destroy();
}

/**
 * 致命的，致死的
 */
interface Lethal {
	void kill();
}

class DragonZilla implements DangerousMonster {
	@Override
	public void menace() {
	}

	@Override
	public void destroy() {
	}
}

/**
 * 吸血鬼
 */
interface Vampire extends DangerousMonster, Lethal {
	void drinkBlood();
}

class VeryBadVampire implements Vampire {
	@Override
	public void menace() {
	}

	@Override
	public void destroy() {
	}

	@Override
	public void kill() {
	}

	@Override
	public void drinkBlood() {
	}
}

/**
 * 恐怖展，通过继承来扩展接口
 */
public class HorrorShow {
	static void u(Monster b) {
		b.menace();
	}

	static void v(DangerousMonster d) {
		d.menace();
		d.destroy();
	}

	static void w(Lethal l) {
		l.kill();
	}

	public static void main(String[] args) {
		DangerousMonster barney = new DragonZilla();
		u(barney);
		v(barney);
		Vampire vlad = new VeryBadVampire();
		u(vlad);
		v(vlad);
		w(vlad);
	}
} ///:~
