package think.in.java.innerclasses.exercise;

/**
 * _B 使用匿名内部类，对原有的练习7进行改造
 * 这个练习表明内部类对它们的外部类对象、即使是私有字段和方法都有访问权限。
 */
public class E07_InnerClassAccess_B {
	private int i = 10;

	private void f() {
		System.out.println("E07_InnerClassAccess.f");
	}

	public void h() {
		new Object() {
			void g() {
				i++;
				f();
			}
		}.g();

		System.out.println("i = " + i);
	}

	public static void main(String args[]) {
		E07_InnerClassAccess_B ica = new E07_InnerClassAccess_B();
		ica.h();
	}
}