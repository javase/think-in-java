package polymorphism.exercise;

public class Bicycle extends Cycle {

	@Override
	public int wheels() {
		return 2;
	}

	public void balance() {
		System.out.println(this.getClass().getSimpleName() + ".balance()");
	}
}