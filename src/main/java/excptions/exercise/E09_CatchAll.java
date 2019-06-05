package excptions.exercise;

import net.mindview.util.Print;

class ExBase extends Exception {
}

class Ex1 extends ExBase {
}

class Ex2 extends ExBase {
}

class Ex3 extends ExBase {
}


class Thrower2 {
	void f() throws Ex1, Ex2, Ex3 {
		throw new Ex1();
	}
}

/**
 * 我们为所有三个异常创建一个公共基类，然后捕获公共基异常
 * created at 2019-06-05 12:46
 * @author lerry
 */
public class E09_CatchAll {
	public static void main(String[] args) {
		try {
			new Thrower2().f();
		}
		catch (ExBase exBase) {
			Print.printlnf("catch ExBase:%s", exBase);
		}
		catch (Exception exception) {
			Print.printlnf("catch Exception:%s", exception);
		}

	}
}
