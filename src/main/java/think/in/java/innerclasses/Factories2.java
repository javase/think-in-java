package think.in.java.innerclasses;//: interfaces/Factories.java

import static net.mindview.util.Print.*;

interface Service2 {
	void method1();

	void method2();
}

interface ServiceFactory2 {
	Service2 getService();
}

class Implementation12 implements Service2 {
	Implementation12() {
	} // Package access

	@Override
	public void method1() {
		print("Implementation1 method1");
	}

	@Override
	public void method2() {
		print("Implementation1 method2");
	}

	public static ServiceFactory2 factory2 = new ServiceFactory2() {
		@Override
		public Service2 getService() {
			return new Implementation12();
		}
	};
}


class Implementation22 implements Service2 {
	Implementation22() {
	} // Package access

	@Override
	public void method1() {
		print("Implementation2 method1");
	}

	@Override
	public void method2() {
		print("Implementation2 method2");
	}

	public static ServiceFactory2 factory2 = new ServiceFactory2() {
		@Override
		public Service2 getService() {
			return new Implementation22();
		}
	};
}


public class Factories2 {
	public static void serviceConsumer(ServiceFactory2 fact) {
		Service2 s = fact.getService();
		s.method1();
		s.method2();
	}

	/**
	 * 使用匿名内部类，对工厂模式进行改造-换种写法
	 * @param args
	 */
	public static void main(String[] args) {
		serviceConsumer(Implementation12.factory2);
		// Implementations are completely interchangeable:
		serviceConsumer(Implementation22.factory2);
	}
} /* Output:
Implementation1 method1
Implementation1 method2
Implementation2 method1
Implementation2 method2
*///:~
