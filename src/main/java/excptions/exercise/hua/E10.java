package excptions.exercise.hua;

import net.mindview.util.Print;

/**
 * created at 2019-06-07 09:42
 * @author lerry
 */

class NewException extends Exception {
}

class SecondException extends Exception {
}

public class E10 {

	public void f() throws Throwable {
		try {
			g();
		}
		catch (NewException e) {
			Print.printlnf("catch exception in f()");
			throw new SecondException().initCause(e);
		}
	}

	public void g() throws NewException {
		Print.printlnf("这是g方法");
		throw new NewException();
	}

	public static void main(String[] args) {
		try {
			new E10().f();
		}
		catch (Throwable throwable) {
			throwable.printStackTrace();
		}
	}
}
