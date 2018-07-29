package interfaces.exercise;

/**
 * Created by limenghua on 2017/11/1.
 * @author limenghua
 */
abstract class NoAbstractMethods {
	void f() {
		System.out.println("f()");
	}

	abstract void g();
}

/**
 * 当一个抽象类不包含任何抽象方法时，无法直接实例化;
 * 就算这个抽象类包含抽象方法，我们也无法直接实例化这个抽象类；
 */
public class E02_Abstract {
	public static void main(String args[]) {
		// 编译出错
		// new NoAbstractMethods();
	}
}
