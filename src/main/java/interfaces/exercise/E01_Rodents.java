package interfaces.exercise;

import static net.mindview.util.Print.print;

/**
 * 把普通的基类，改造成抽象类；
 * 把原来基类里面被继承的方法，修改成抽象方法；
 */
abstract class Rodent {
	public abstract void hop();

	public abstract void scurry();

	public abstract void reproduce();

	@Override
	public String toString() {
		return "Rodent";
	}
}

class Mouse extends Rodent {
	@Override
	public void hop() {
		print("Mouse hopping");
	}

	@Override
	public void scurry() {
		print("Mouse scurrying");
	}

	@Override
	public void reproduce() {
		print("Making more Mice");
	}

	@Override
	public String toString() {
		return "Mouse";
	}
}

class Gerbil extends Rodent {
	@Override
	public void hop() {
		print("Gerbil hopping");
	}

	@Override
	public void scurry() {
		print("Gerbil scurrying");
	}

	@Override
	public void reproduce() {
		print("Making more Gerbils");
	}

	@Override
	public String toString() {
		return "Gerbil";
	}
}

class Hamster extends Rodent {
	@Override
	public void hop() {
		print("Hamster hopping");
	}

	@Override
	public void scurry() {
		print("Hamster scurrying");
	}

	@Override
	public void reproduce() {
		print("Making more Hamsters");
	}

	@Override
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
