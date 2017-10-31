package think.in.java.polymorphism.exercise;

public class Tricycle extends Cycle {
	@Override
	public int wheels() {
		return 3;
	}

	public void balance() {
		System.out.println(this.getClass().getSimpleName() + ".balance()");
	}
}