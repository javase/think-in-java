package think.in.java.polymorphism.exercise;

public class Unicycle extends Cycle {

	@Override
	public int wheels() {
		return 1;
	}

	public void balance(){
		System.out.println(this.getClass().getSimpleName() + ".balance()");
	}
}