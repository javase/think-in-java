package excptions.exercise;


import net.mindview.util.Print;

/**
 * 基类异常
 */
class Level1Exception extends Exception {
}

class Level2Exception extends Level1Exception {
}

class Level3Exception extends Level2Exception {
}

class A {
	public void f() throws Level1Exception {
		throw new Level1Exception();
	}
}

class B extends A {
	@Override
	public void f() throws Level2Exception {
		throw new Level2Exception();
	}
}

class C extends B {
	@Override
	public void f() throws Level3Exception {
		throw new Level3Exception();
	}
}

/**
 * 编译器强制您捕获Level1Exception，因为这是a.f()抛出的。
 * created at 2019-06-11 20:04
 * @author lerry
 */
public class E25_ThreeLevelExceptions {

	public static void main(String[] args) {
		// 向上转型
		A a = new C();
		try {
			a.f();
		}
		catch (Level1Exception e) {
			Print.printlnf("Catch %s", e);
		}
	}
}
