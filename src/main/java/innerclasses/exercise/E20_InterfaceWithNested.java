package innerclasses.exercise;

interface WithNested {

	class Nested {
		int i;

		public Nested(int i) {
			this.i = i;
		}

		void f() {
			System.out.println(String.format("Nested.f(),i is %s", i));
		}
	}
}

class B2 implements WithNested {
}

public class E20_InterfaceWithNested {
	public static void main(String args[]) {
		B2 b = new B2();
		WithNested.Nested ne = new WithNested.Nested(5); ne.f();
	}
} /* Output:
		 Nested.f
         *///:~