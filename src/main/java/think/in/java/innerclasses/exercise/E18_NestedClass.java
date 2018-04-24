package think.in.java.innerclasses.exercise;

/**
 * Created by limenghua on 2018/3/4.
 * @author limenghua
 */
public class E18_NestedClass {

	static class NestedClass {
		void f() {
			System.out.println("Nested.f()");
		}
	}

	/**
	 * 在定义静态内部类的内部，可以直接通过内部类名字引用这个类
	 * @param args
	 */
	public static void main(String[] args) {
		NestedClass nestedClass = new NestedClass();
		nestedClass.f();
	}
}

/**
 * 在外部，如果想引用静态内部类，需要外部类和名字和内部类的名字
 */
class Other {
	static void f() {
		E18_NestedClass.NestedClass ne = new E18_NestedClass.NestedClass();
		System.out.println("在其他类中引用嵌套类");
		ne.f();
	}

	public static void main(String[] args) {
		f();
	}
}


