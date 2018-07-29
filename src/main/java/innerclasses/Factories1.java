package innerclasses;//: interfaces/Factories.java

import static net.mindview.util.Print.*;

interface Service {
	void method1();

	void method2();
}

interface ServiceFactory {
	Service2 getService();
}

class Implementation1 implements Service2 {
	Implementation1() {
	} // Package access

	@Override
	public void method1() {
		print("Implementation1 method1");
	}

	@Override
	public void method2() {
		print("Implementation1 method2");
	}
}


class Implementation2 implements Service2 {
	Implementation2() {
	} // Package access

	@Override
	public void method1() {
		print("Implementation2 method1");
	}

	@Override
	public void method2() {
		print("Implementation2 method2");
	}
}


public class Factories1 {
	public static void serviceConsumer(ServiceFactory2 fact) {
		Service2 s = fact.getService();
		s.method1();
		s.method2();
	}

	/**
	 * 使用匿名内部类，对工厂模式进行改造
	 * @param args
	 */
	public static void main(String[] args) {
		serviceConsumer(new ServiceFactory2() {
			@Override
			public Service2 getService() {
				return new Implementation1();
			}
		});
		// Implementations are completely interchangeable:
		serviceConsumer(new ServiceFactory2() {
			@Override
			public Service2 getService() {
				return new Implementation2();
			}
		});
	}
} /* Output:
Implementation1 method1
Implementation1 method2
Implementation2 method1
Implementation2 method2
*///:~
