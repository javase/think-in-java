package think.in.java.holding.exercise;

import java.util.ArrayList;

/**
 * 沙鼠
 */
class Gerbil {
	private final int gerbilNumber;

	Gerbil(int gerbilNumber) {
		this.gerbilNumber = gerbilNumber;
	}

	@Override
	public String toString() {
		return "gerbil-" + gerbilNumber;
	}

	/**
	 * 跳跃
	 */
	public void hop() {
		System.out.println(this + " is hopping");
	}
}

public class E01_Gerbil {
	public static void main(String args[]) {
		ArrayList<Gerbil> gerbils = new ArrayList<Gerbil>();
		for (int i = 0; i < 10; i++) {
			gerbils.add(new Gerbil(i));
		}
		for (int i = 0; i < gerbils.size(); i++) {
			gerbils.get(i).hop();
		}
	}
}