package typeinfo;//: typeinfo/SimpleProxyDemo.java

import static net.mindview.util.Print.*;

/**
 * 代理结构的简单示例
 */
class SimpleProxyDemo {
	/**
	 * 消费者
	 * @param iface  接口类型 可以接收真实对象、也可以接收实现了同样接口的代理对象
	 */
	public static void consumer(Interface iface) {
		iface.doSomething();
		iface.somethingElse("bonobo");
	}

	public static void main(String[] args) {
		consumer(new RealObject());
		consumer(new SimpleProxy(new RealObject()));
	}
}

interface Interface {
	void doSomething();

	void somethingElse(String arg);
}

/**
 * 真实对象（被代理的对象）
 */
class RealObject implements Interface {
	@Override
	public void doSomething() {
		print("doSomething");
	}

	@Override
	public void somethingElse(String arg) {
		print("somethingElse " + arg);
	}
}

class SimpleProxy implements Interface {
	private Interface proxied;

	public SimpleProxy(Interface proxied) {
		this.proxied = proxied;
	}

	@Override
	public void doSomething() {
		print("SimpleProxy doSomething");
		proxied.doSomething();
	}

	@Override
	public void somethingElse(String arg) {
		print("SimpleProxy somethingElse " + arg);
		proxied.somethingElse(arg);
	}
}

/* Output:
doSomething
somethingElse bonobo
SimpleProxy doSomething
doSomething
SimpleProxy somethingElse bonobo
somethingElse bonobo
*///:~
