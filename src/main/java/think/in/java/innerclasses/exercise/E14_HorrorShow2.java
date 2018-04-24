package think.in.java.innerclasses.exercise;


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

interface Vampire extends DangerousMonster, Lethal {
	void drinkBlood();
}

class HorrorShow2 {
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
}

/**
 * 使用内部类来重新写interfaces/HorrorShow.java
 */
public class E14_HorrorShow2 {
	public static void main(String[] args) {

		DangerousMonster barney = new DangerousMonster() {
			public void menace() {
			}

			public void destroy() {
			}
		};

		HorrorShow2.u(barney);
		HorrorShow2.v(barney);

		Vampire vlad = new Vampire() {
			public void menace() {
			}

			public void destroy() {
			}

			public void kill() {
			}

			public void drinkBlood() {
			}
		};
		HorrorShow2.u(vlad);
		HorrorShow2.v(vlad);
		HorrorShow2.w(vlad);
	}
} ///:~