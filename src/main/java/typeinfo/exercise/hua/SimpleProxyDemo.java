package typeinfo.exercise.hua;

import static net.mindview.util.Print.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 代理结构的简单示例
 * 使其可以度量方法调用的次数
 */
class SimpleProxyDemo {
	/**
	 * 消费者
	 * @param iface 接口类型 可以接收真实对象、也可以接收实现了同样接口的代理对象
	 */
	public static void consumer(Interface iface) {
		iface.doSomething();
		iface.somethingElse("bonobo");
	}

	public static void main(String[] args) {
		consumer(new RealObject());
		SimpleProxy simpleProxy = new SimpleProxy(new RealObject());

		printlnf("\n\nSimpleProxy部分");
		consumer(simpleProxy);
		consumer(simpleProxy);
		printlnf("打印方法调用次数:%s", simpleProxy.getMethodInvokeTimesMap());
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

	private Map<String, Integer> methodInvokeTimesMap = new HashMap<>();

	public Map<String, Integer> getMethodInvokeTimesMap() {
		return methodInvokeTimesMap;
	}

	public SimpleProxy(Interface proxied) {
		this.proxied = proxied;
	}

	@Override
	public void doSomething() {
		print("SimpleProxy doSomething");
		proxied.doSomething();

		if (methodInvokeTimesMap.get("doSomething") != null) {
			int times = methodInvokeTimesMap.get("doSomething");
			times++;
			methodInvokeTimesMap.put("doSomething", times);
		}
		else {
			int times = 1;
			methodInvokeTimesMap.put("doSomething", times);
		}
	}

	@Override
	public void somethingElse(String arg) {
		print("SimpleProxy somethingElse " + arg);
		proxied.somethingElse(arg);

		if (methodInvokeTimesMap.get("somethingElse") != null) {
			int times = methodInvokeTimesMap.get("somethingElse");
			times++;
			methodInvokeTimesMap.put("somethingElse", times);
		}
		else {
			int times = 1;
			methodInvokeTimesMap.put("somethingElse", times);
		}
	}
}


