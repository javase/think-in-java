package think.in.java.interfaces.exercise;

/**
 * 摇动
 */
interface Tossing {
	boolean event();
}

interface TossingFactory {
	Tossing getTossing();
}

/**
 * 抛硬币
 */
class CoinTossing implements Tossing {
	private int events;

	private static final int EVENTS = 2;

	@Override
	public boolean event() {
		System.out.println("Coin tossing event " + events);
		return ++events != EVENTS;
	}
}

class CoinTossingFactory implements TossingFactory {
	@Override
	public CoinTossing getTossing() {
		return new CoinTossing();
	}
}

/**
 * 骰子
 */
class DiceTossing implements Tossing {
	private int events;

	private static final int EVENTS = 6;

	@Override
	public boolean event() {
		System.out.println("Dice tossing event " + events);
		return ++events != EVENTS;
	}
}

class DiceTossingFactory implements TossingFactory {
	@Override
	public DiceTossing getTossing() {
		return new DiceTossing();
	}
}

public class E19_TossingFramework {
	public static void simulate(TossingFactory fact) {
		Tossing t = fact.getTossing();
		while (t.event()) {
			;
		}
	}

	public static void main(String[] args) {
		simulate(new CoinTossingFactory());
		simulate(new DiceTossingFactory());
	}
}