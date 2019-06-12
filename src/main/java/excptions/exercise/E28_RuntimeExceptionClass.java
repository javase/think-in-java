package excptions.exercise;

class MyRuntimeException extends RuntimeException {
	public MyRuntimeException(String s) {
		super(s);
	}
}

/**
 * 当异常类型为运行时异常时，编译器允许省略try语句
 */
public class E28_RuntimeExceptionClass {
	public static void main(String args[]) {
		throw new MyRuntimeException("MyRuntimeException msg");
	}
}