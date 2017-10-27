package think.in.java.reusing.exercise;

class WithFinalMethod {
	// 不指定 private 关键字
	final void f() {
	}
}

public class E21_FinalMethod extends WithFinalMethod {
	// final void f() {} // 会报错： overridden method is final

	public static void main(String args[]) {
	}
} ///:~

