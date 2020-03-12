package typeinfo.classa;

import static net.mindview.util.Print.*;

public class A {
	private void a() {
		System.out.println("A.a()");
	}

	protected void b() {
		printlnf("[type info:%s]A.b()", this.getClass().getName());
	}

	void c() {
		System.out.println("A.c()");
	}
}