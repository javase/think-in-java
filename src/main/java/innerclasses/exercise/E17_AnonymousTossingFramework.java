package innerclasses.exercise;

interface Tossing {
	boolean event();
}

interface TossingFactory {
	Tossing getTossing();
}

class CoinTossing implements Tossing {
	private int events;

	private static final int EVENTS = 2;

	@Override
	public boolean event() {
		System.out.println("Coin tossing event " + events);
		return ++events != EVENTS;
	}

	public static TossingFactory factory =
			new TossingFactory() {
				@Override
				public CoinTossing getTossing() {
					return new CoinTossing();
				}
			};
}

class DiceTossing implements Tossing {
	private int events;

	private static final int EVENTS = 6;

	@Override
	public boolean event() {
		System.out.println("Dice tossing event " + events);
		return ++events != EVENTS;
	}

	public static TossingFactory factory =
			new TossingFactory() {
				@Override
				public DiceTossing getTossing() {
					return new DiceTossing();
				}
			};
}

/**
 * 使用匿名内部类对interfaces包中练习19进行改造
 */
public class E17_AnonymousTossingFramework {
	public static void simulate(TossingFactory fact) {
		Tossing t = fact.getTossing();
		while (t.event()) {
			;
		}
	}

	public static void main(String[] args) {
		simulate(CoinTossing.factory);
		simulate(DiceTossing.factory);
	}
} /* Output:
		 Coin tossing event 0
         Coin tossing event 1
         Dice tossing event 0
         Dice tossing event 1
         Dice tossing event 2
         Dice tossing event 3
         Dice tossing event 4
         Dice tossing event 5
         *///:~
