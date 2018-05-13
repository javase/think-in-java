package think.in.java.interfaces;//: interfaces/Factories.java

import static net.mindview.util.Print.*;

interface Service {
	void method1();

	void method2();
}

interface ServiceFactory {
	Service getService();
}

class Implementation1 implements Service {
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

/**
 * 创建接口1实现类的工厂
 */
class Implementation1Factory implements ServiceFactory {
	@Override
	public Service getService() {
		return new Implementation1();
	}
}

class Implementation2 implements Service {
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

/**
 * 创建接口2实现类的工厂
 */
class Implementation2Factory implements ServiceFactory {
	@Override
	public Service getService() {
		return new Implementation2();
	}
}

public class Factories {
	public static void serviceConsumer(ServiceFactory fact) {
		Service s = fact.getService();
		s.method1();
		s.method2();
	}

	public static void main(String[] args) {
		serviceConsumer(new Implementation1Factory());
		// Implementations are completely interchangeable:
		serviceConsumer(new Implementation2Factory());
	}
} /* Output:
Implementation1 method1
Implementation1 method2
Implementation2 method1
Implementation2 method2
*///:~
