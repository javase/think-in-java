package innerclasses;//: innerclasses/LocalInnerClass.java
// Holds a sequence of Objects.

import static net.mindview.util.Print.*;


interface Counter {
	int next();
}

/**
 * 既然局部内部类的名字在方法外是不可见的，那为什么我们仍然使用局部内部类而不是匿名内部类呢？ 唯一的理由是：
 *     * 我们需要一个已命名的构造器，或者需要重载构造器，而匿名内部类只能用于实例初始化
 *     * 使用局部内部类而不使用匿名内部类的另一个理由就是：需要不止一个该内部类的对象
 *
 * Java编译器生成的.class文件分别为：
 * Counter.class
 * LocalInnerClass.class
 * LocalInnerClass$1.class
 * LocalInnerClass$1LocalCounter01.class
 * LocalInnerClass$1LocalCounter02.class
 */
public class LocalInnerClass {

	private int count = 0;

	Counter getCounter(final String name) {
		/**
		 * 局部内部类、在方法体里面
		 * A local inner class:
		 */
		class LocalCounter01 implements Counter {
			public LocalCounter01() {
				// Local inner class can have a constructor
				print("LocalCounter()");
			}

			private int i = 0;

			/**
			 * 可以对构造器进行重载
			 * @param i
			 */
			public LocalCounter01(int i) {
				this.i = i;
			}

			@Override
			public int next() {
				// Access local final
				printnb(name);
				return count++;
			}
		}

		/**
		 * 需要不止一个该内部类的对象，可以使用局部内部类来实现
		 */
		class LocalCounter02 implements Counter {
			public LocalCounter02() {
				// Local inner class can have a constructor
				print("LocalCounter()");
			}

			private int i = 0;

			/**
			 * 可以对构造器进行重载
			 * @param i
			 */
			public LocalCounter02(int i) {
				this.i = i;
			}

			@Override
			public int next() {
				// Access local final
				printnb(name);
				return count++;
			}
		}
		return new LocalCounter01();
	}

	/**
	 * 匿名内部类
	 * The same thing with an anonymous inner class:
	 * @param name
	 * @return
	 */
	Counter getCounter2(final String name) {
		return new Counter() {
			// Anonymous inner class cannot have a named
			// constructor, only an instance initializer:
			{
				print("Counter()");
			}

			@Override
			public int next() {
				// Access local final
				printnb(name);
				return count++;
			}
		};
	}

	public static void main(String[] args) {
		LocalInnerClass lic = new LocalInnerClass();
		Counter
				c1 = lic.getCounter("Local inner "),
				c2 = lic.getCounter2("Anonymous inner ");
		for (int i = 0; i < 5; i++) {
			print(c1.next());
		}
		for (int i = 0; i < 5; i++) {
			print(c2.next());
		}
	}
} /* Output:
LocalCounter()
Counter()
Local inner 0
Local inner 1
Local inner 2
Local inner 3
Local inner 4
Anonymous inner 5
Anonymous inner 6
Anonymous inner 7
Anonymous inner 8
Anonymous inner 9
*///:~
