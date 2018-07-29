package innerclasses.exercise;

interface Cycle {
	int wheels();
}

interface CycleFactory {
	Cycle getCycle();
}

class Unicycle implements Cycle {
	@Override
	public int wheels() {
		return 1;
	}

	public static CycleFactory factory =
			new CycleFactory() {
				@Override
				public Unicycle getCycle() {
					return new Unicycle();
				}
			};
}

class Bicycle implements Cycle {
	@Override
	public int wheels() {
		return 2;
	}

	public static CycleFactory factory =
			new CycleFactory() {
				@Override
				public Bicycle getCycle() {
					return new Bicycle();
				}
			};
}

class Tricycle implements Cycle {
	@Override
	public int wheels() {
		return 3;
	}

	public static CycleFactory factory =
			new CycleFactory() {
				@Override
				public Tricycle getCycle() {
					return new Tricycle();
				}
			};
}

/**
 * 使用匿名内部类对interfaces包中练习18进行改造
 */
public class E16_AnonymousCycleFactories {
	public static void ride(CycleFactory fact) {
		Cycle c = fact.getCycle();
		System.out.println("Num. of wheels: " + c.wheels());
	}

	public static void main(String[] args) {
		ride(Unicycle.factory);
		ride(Bicycle.factory);
		ride(Tricycle.factory);
	}
} /* Output:
		 Num. of wheels: 1
         Num. of wheels: 2
         Num. of wheels: 3
         *///:~