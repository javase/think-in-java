package excptions.exercise;


class Thrower {
	// 会报错：未报告的异常错误 exceptions.exercise.MyException,必须对其进行捕获或声明以便抛出
//	public void f() {
//		throw new MyException("inside f()");
//	}

	public void g() throws MyException {
		throw new MyException("inside f()");
	}
}

/**
 * created at 2019-06-05 12:35
 * @author lerry
 */
public class E08_ExceptionSpecification {
	public static void main(String[] args) {
		try {
			new Thrower().g();
		}
		catch (MyException e) {
			e.printMsg();
		}
	}
}
