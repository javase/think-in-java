package innerclasses.exercise;

class Outer3 {
	class Inner {
		{
			System.out.println("Inner created");
		}
	}
}

/**
 * 实例化内部类的例子
 */
public class E05_InstanceOfInner {
	public static void main(String args[]) {
		Outer3 o = new Outer3();
		Outer3.Inner i = o.new Inner();
	}
}