package think.in.java.interfaces.exercise;

import static net.mindview.util.Print.print;

/**
 * 把普通的基类，改造成抽象类；
 * 把原来基类里面被继承的方法，修改成抽象方法；
 */
abstract class Rodent {
	public abstract void hop();

	public abstract void scurry();

	public abstract void reproduce();

	public String toString() {
		return "Rodent";
	}
}

class Mouse extends Rodent {
	public void hop() {
		print("Mouse hopping");
	}

	public void scurry() {
		print("Mouse scurrying");
	}

	public void reproduce() {
		print("Making more Mice");
	}

	public String toString() {
		return "Mouse";
	}
}

class Gerbil extends Rodent {
	public void hop() {
		print("Gerbil hopping");
	}

	public void scurry() {
		print("Gerbil scurrying");
	}

	public void reproduce() {
		print("Making more Gerbils");
	}

	public String toString() {
		return "Gerbil";
	}
}

class Hamster extends Rodent {
	public void hop() {
		print("Hamster hopping");
	}

	public void scurry() {
		print("Hamster scurrying");
	}

	public void reproduce() {
		print("Making more Hamsters");
	}

	public String toString() {
		return "Hamster";
	}
}


public class E01_Rodents {
	public static void main(String args[]) {
		Rodent[] rodents = {
				new Mouse(),
				new Gerbil(),
				new Hamster(),
		};
		for (Rodent r : rodents) {
			r.hop();
			r.scurry();
			r.reproduce();
			print(r);
			print("-------");
		}
	}
}
