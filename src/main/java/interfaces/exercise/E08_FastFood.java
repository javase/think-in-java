package interfaces.exercise;

import static net.mindview.util.Print.print;

import polymorphism.Sandwich;

/**
 * Created by limenghua on 2017/11/2.
 * @author limenghua
 */
interface FastFood {
	void rushOrder();

	void gobble();
}

class FastSandwich extends Sandwich implements FastFood {
	// 旺盛
	@Override
	public void rushOrder() {
		print("Rushing your sandwich order");
	}

	/**
	 * 狼吞虎咽
	 */
	@Override
	public void gobble() {
		// Chomp：咯咯咬牙  snort：发哼声
		print("Chomp! Snort! Gobble!");
	}
}

public class E08_FastFood {
	public static void main(String args[]) {
		FastSandwich burger = new FastSandwich();
		print("Fries with that?");
		print("Super Size?");
		burger.rushOrder();
		burger.gobble();
	}
}

