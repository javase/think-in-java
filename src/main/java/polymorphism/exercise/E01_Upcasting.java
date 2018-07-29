package polymorphism.exercise;


import static net.mindview.util.Print.print;

/**
 * 添加轮子个数的打印，各个子类打印的轮子个数不一样，多态发挥了作用。
 * 如果不覆盖父类方法，则仍然会调用父类的方法而不是子类的方法。
 */
public class E01_Upcasting {
	public static void ride(Cycle c) {
		print(String.format(".ride() 类型名称：%s，轮子个数：%d", c.getClass().getSimpleName(), c.wheels()));
	}

	public static void main(String[] args) {
		ride(new Cycle());    // No upcasting
		ride(new Unicycle()); // Upcast
		ride(new Bicycle());  // Upcast
		ride(new Tricycle()); // Upcast
	}
} ///:~