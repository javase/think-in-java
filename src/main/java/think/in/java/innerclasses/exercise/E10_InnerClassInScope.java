package think.in.java.innerclasses.exercise;

import think.in.java.innerclasses.exercise.exercise6.SimpleInterface;

/**
 * 只有当返回语句在其范围内时，内部类仍然可见;
 * 如果没有，则内部类定义超出范围。
 */
public class E10_InnerClassInScope {
	public SimpleInterface get() {

		// 内部类放在方法的一个作用域内
		{
			class SI implements SimpleInterface {
				public void f() {
					System.out.println("SI.f");
				}
			}
			return new SI();
		}
		// 在作用域范围外，是访问不到SI类的
//		{
//			return new SI();
//		}
	}

	public static void main(String args[]) {
		SimpleInterface si =
				new E10_InnerClassInScope().get();
		si.f();
	}
} /* Output:
		 SI.f
         *///:~