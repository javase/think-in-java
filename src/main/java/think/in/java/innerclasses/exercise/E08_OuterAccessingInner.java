package think.in.java.innerclasses.exercise;


class Outer4 {

	class Inner {
		// 内部类的私有属性
		private int j;

		private void h() {
			System.out.println("Inner.h called");
			System.out.println("Inner.j = " + j);
		}
	}

	/**
	 * 外部类也拥有内部类私有成员的访问权限
	 */
	public void testInnerAccess() {
		Inner i = new Inner();
		i.j = 47;
		i.h();
	}
}

public class E08_OuterAccessingInner {
	public static void main(String args[]) {
		Outer4 o = new Outer4();
		o.testInnerAccess();
	}
}