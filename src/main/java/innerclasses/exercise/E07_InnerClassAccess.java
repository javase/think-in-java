package innerclasses.exercise;

/**
 * 这个练习表明内部类对它们的外部类对象、即使是私有字段和方法都有访问权限。
 */
public class E07_InnerClassAccess {
	private int i = 10;

	private void f() {
		System.out.println("E07_InnerClassAccess.f");
	}

	class Inner {
		void g() {
			i++;
			f();
		}
	}

	public void h() {
		Inner in = new Inner();
		in.g();
		System.out.println("i = " + i);
	}

	public static void main(String args[]) {
		E07_InnerClassAccess ica = new E07_InnerClassAccess();
		ica.h();
	}
}