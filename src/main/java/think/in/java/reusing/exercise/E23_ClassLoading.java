package think.in.java.reusing.exercise;

class LoadTest {
	// The static clause is executed
	// upon class loading:
	static {
		System.out.println("静态代码块  Loading LoadTest");
	}

	static void staticMember() {
	}

	public static final int MEMBER = 1;
}

/**
 * 创建类的实例时，或者访问类的静态成员时，会进行类的加载
 */
public class E23_ClassLoading {
	public static void main(String args[]) {
		System.out.println("Calling static member");
		// 调用父类的静态方法时，会加载静态代码块里面的内容
//		LoadTest.staticMember();
		// 调用静态变量时，不会触发类加载
		System.out.println(LoadTest.MEMBER);
		System.out.println("Creating an object");

		//new LoadTest();
	}
}