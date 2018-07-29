package polymorphism;//: polymorphism/CovariantReturn.java

class Grain {
	@Override
	public String toString() {
		return "Grain";
	}
}

class Wheat extends Grain {
	@Override
	public String toString() {
		return "Wheat";
	}
}

class Mill {
	Grain process() {
		return new Grain();
	}
}

class WheatMill extends Mill {
	@Override
	Wheat process() {
		return new Wheat();
	}
}

/**
 * 在导出类中的被覆盖方法可以返回  基类方法的返回类型的某种导出类型
 */
public class CovariantReturn {
	public static void main(String[] args) {
		Mill m = new Mill();
		Grain g = m.process();
		System.out.println(g);

		m = new WheatMill();
		g = m.process();
		System.out.println(g);
	}
} /* Output:
Grain
Wheat
*///:~
