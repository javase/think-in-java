package innerclasses.exercise;

import static net.mindview.util.Print.print;

import innerclasses.exercise.exercise6.SimpleInterface;

class Outer5 {

	private class Inner implements SimpleInterface {
		@Override
		public void f() {
			System.out.println("Outer5.Inner.f");
		}
	}

	public SimpleInterface get() {
		print("获得向上转型的对象");
		return new Inner();
	}

	public Inner get2() {
		print("直接获取内部类对象");
		return new Inner();
	}
}

public class E11_HiddenInnerClass {
	public static void main(String args[]) {
		Outer5 out = new Outer5();
		SimpleInterface si = out.get();
		// 只可以使用向上转型的类型，而不可直接使用私有内部类的类型，因为私有内部类对外部不可见
		si = out.get2();
		si.f();
		// Won't compile -- 'Inner' not visible:
		//! Inner i1 = out.get2();
		//! Inner i2 = (Inner)si;
	}
} ///:~