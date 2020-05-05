package functional;// functional/RunnableMethodReference.java
// (c)2017 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Method references with interface Runnable

/**
 * On Java 8读书笔记-第十三章 函数式编程
 * 方法引用-Runnable接口
 * Thread 对象将 Runnable 作为其构造函数参数，并具有会调用 run() 的方法 start()。
 * 注意，只有匿名内部类才需要具有名为 run() 的方法。
 * created at 2020-05-02 04:03
 * @author lerry
 */
public class RunnableMethodReference {
	public static void main(String[] args) {

		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Anonymous");
			}
		}).start();


		new Thread(
				() -> System.out.println("lambda")
		).start();


		/*
		 * 可以接受类似Runnable方法的方法引用！
		 */
		new Thread(Go::go).start();
	}
}
/* Output:
Anonymous
lambda
Go::go()
*/

class Go {
	/**
	 * 和Runnable接口的run方法签名一样，不带参数，也没有返回值
	 */
	static void go() {
		System.out.println("Go::go()");
	}
}
