package think.in.java.innerclasses;

/**
 * 使用嵌套类来放置测试代码
 * Created by limenghua on 2018/3/11.
 * @author limenghua
 */
public class TestBed {
	public void f() {
		System.out.println("f()");
	}

	public static class Tester {
		public static void main(String[] args) {
			TestBed t = new TestBed();
			t.f();
		}
	}
}
