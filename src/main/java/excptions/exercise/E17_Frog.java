package excptions.exercise;

class Frog2 extends polymorphism.Frog {
	@Override
	protected void dispose() {
		super.dispose();
	}
}

/**
 * 即使在try-finally的中间返回，也可以起作用。
 */
public class E17_Frog {
	public static void main(String[] args) {
		Frog2 frog = new Frog2();

		try {   // No return in the middle...
		}
		finally {
			frog.dispose();
		}

		frog = new Frog2();
		try {
			// With return in the middle...
			return;
		}
		finally {
			frog.dispose();
		}
	}
}