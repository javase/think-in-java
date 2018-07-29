package polymorphism.exercise;

import static net.mindview.util.Print.print;

/**
 * Created by limenghua on 2017/10/30.
 * @author limenghua
 */
class Member {
	public Member(String id) {
		print("Member constructor " + id);
	}
}

class Rodent2 {
	Member m1 = new Member("r1"), m2 = new Member("r2");

	public Rodent2() {
		print("Rodent constructor");
	}

	public void hop() {
		print("Rodent hopping");
	}

	public void scurry() {
		print("Rodent scurrying");
	}

	public void reproduce() {
		print("Making more Rodents");
	}

	@Override
	public String toString() {
		return "Rodent";
	}
}

class Mouse2 extends Rodent2 {
	Member m1 = new Member("m1"), m2 = new Member("m2");

	public Mouse2() {
		print("Mouse constructor");
	}

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

class Gerbil2 extends Rodent2 {
	Member m1 = new Member("g1"), m2 = new Member("g2");

	public Gerbil2() {
		print("Gerbil constructor");
	}

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

class Hamster2 extends Rodent2 {
	Member m1 = new Member("h1"), m2 = new Member("h2");

	public Hamster2() {
		print("Hamster constructor");
	}

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

/**
 * 观察基类和导出类初始化顺序
 */
public class E12_RodentInitialization {
	public static void main(String args[]) {
		new Hamster2();
	}
}
