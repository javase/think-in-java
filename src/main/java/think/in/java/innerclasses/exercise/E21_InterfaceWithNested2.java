package think.in.java.innerclasses.exercise;

interface I {

	void f();

	void g();


	class Nested {
		// 嵌套类的静态方法中，调用接口的方法
		static void call(I impl) {
			System.out.println("Calling I.f()");
			impl.f();
			System.out.println("Calling I.g()");
			impl.g();
		}
	}
}

public class E21_InterfaceWithNested2 {
	public static void main(String[] args) {

		I impl = new I() {

			public void f() {
				System.out.println("implemented f()");
			}

			public void g() {
				System.out.println("implemented g()");
			}
		};
		// 将接口实现的实例，传递给内部类的方法
		I.Nested.call(impl);
	}
}