package think.in.java.innerclasses.exercise;

/**
 * U接口有三个方法
 */
interface U {
	void f();

	void g();

	void h();
}

/**
 * 包含一个方法
 */
class A {

	/**
	 * 有一个匿名内部类，生成指向U的引用
	 * @return
	 */
	public U getU() {

		return new U() {
			@Override
			public void f() {
				System.out.println(String.format("[%s-%s].f()", this.getClass().getName(), this.getClass().hashCode()));
			}

			@Override
			public void g() {
				System.out.println(String.format("[%s].g()", this.getClass().getName()));
			}

			@Override
			public void h() {
				System.out.println(String.format("[%s].h()", this.getClass().getName()));
			}
		};
	}
}

/**
 * 包含一个由U构成的数组
 */
class B {

	U[] ua;

	/**
	 * 在构造器中，创建一个新的数组
	 * @param size
	 */
	public B(int size) {
		ua = new U[size];
	}

	/**
	 * 接收对U的引用，并存储到数组中
	 * @param elem
	 * @return
	 */
	public boolean add(U elem) {
		for (int i = 0; i < ua.length; i++) {
			if (ua[i] == null) {
				ua[i] = elem;
				return true;
			}
		}
		// Couldn't find any space
		return false;
	}

	/**
	 * 将数组中指定下标的引用设置为Null
	 * @param i
	 * @return
	 */
	public boolean setNull(int i) {
		if (i < 0 || i >= ua.length) {
			// Value out of bounds
			return false;
		}
		// (Normally throw an exception)
		ua[i] = null;
		return true;
	}

	/**
	 * 遍历数组
	 */
	public void callMethods() {
		for (int i = 0; i < ua.length; i++) {
			if (ua[i] != null) {
				ua[i].f();
				ua[i].g();
				ua[i].h();
			}
		}
	}
}

public class E23_UAB {
	public static void main(String args[]) {
		// A类型的数组
		A[] aa = {new A(), new A(), new A()};
		B b = new B(3);
		// 使用A类对象所产生的U类型引用，来填充B对象的数组
		for (int i = 0; i < aa.length; i++) {
			b.add(aa[i].getU());
		}
		b.callMethods();
		System.out.println("****");
		// 从B中移除某些U的引用
		b.setNull(0);
		b.callMethods();
	}
}