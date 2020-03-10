package typeinfo.exercise;

import static net.mindview.util.Print.*;

/**
 * 可以观察简易代理时，被代理对象的执行耗时  纳秒单位
 * 和书上的不太一致，书上要求"使其可以度量方法调用的次数"，而不是统计方法调用耗时
 * created at 2020-03-10 07:38
 * @author lerry
 */
public class E21_SimpleProxyDemo {
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
		long start = System.nanoTime();
		proxied.doSomething();
		long duration = System.nanoTime() - start;
		print("METHOD-CALL TIME: " + duration);
	}

	@Override
	public void somethingElse(String arg) {
		print("SimpleProxy somethingElse " + arg);
		long start = System.nanoTime();
		proxied.somethingElse(arg);
		long duration = System.nanoTime() - start;
		print("METHOD-CALL TIME: " + duration);
	}
}

