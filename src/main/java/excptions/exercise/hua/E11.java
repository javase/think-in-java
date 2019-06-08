package excptions.exercise.hua;

import net.mindview.util.Print;

/**
 * created at 2019-06-07 09:42
 * @author lerry
 */

class NewException01 extends Exception {
}

class SecondException01 extends Exception {
}

public class E11 {

	public void f() throws Throwable {
		try {
			g();
		}
		catch (NewException01 e) {
			Print.printlnf("catch exception in f()");
//			RuntimeException runtimeException = new RuntimeException();
//			throw e.initCause(runtimeException);
			throw new RuntimeException(e);
		}
	}

	public void g() throws NewException01 {
		Print.printlnf("这是g方法");
		throw new NewException01();
	}

	public static void main(String[] args) {
		try {
			new E11().f();
		}
		catch (Throwable throwable) {
			throwable.printStackTrace();
		}
	}
}
