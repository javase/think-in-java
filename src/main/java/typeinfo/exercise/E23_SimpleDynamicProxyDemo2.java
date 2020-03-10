package typeinfo.exercise;

import static net.mindview.util.Print.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * created at 2020-03-10 08:00
 * @author lerry
 */
public class E23_SimpleDynamicProxyDemo2 {
	public static void consumer(Interface iface) {
		iface.doSomething();
		iface.somethingElse("bonobo");
	}

	public static void main(String[] args) {
		RealObject real = new RealObject();
		consumer(real);
		Interface proxy = (Interface) Proxy.newProxyInstance(
				Interface.class.getClassLoader(),
				new Class<?>[] {Interface.class},
				new DynamicProxyHandler2(real));
		consumer(proxy);
	}
}

class DynamicProxyHandler2 implements InvocationHandler {
	private Object proxied;

	public DynamicProxyHandler2(Object proxied) {
		this.proxied = proxied;
	}

	/**
	 * 该程序在invoke()内部进入无限循环，并最终崩溃(使用java.lang.StackOverflowError)。
	 * 我们调用toString()方法来打印代理对象;
	 * 但是，我们通过接口通过代理重定向调用，以及从对象继承的方法的调用。
	 * @param proxy
	 * @param method
	 * @param args
	 * @return
	 * @throws Throwable
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		printlnf("proxy:%s", proxy.toString());
		// printlnf("\t****invoke方法的参数打印如下： \n\tproxy.getClass():%s \n\tmethod: %s\n\targs:%s", proxy.getClass(), method, Arrays.toString(args));
		return method.invoke(proxied, args);
	}
}
/*
output:
doSomething
somethingElse bonobo
Exception in thread "main" java.lang.StackOverflowError
	at typeinfo.exercise.DynamicProxyHandler2.invoke(E23_SimpleDynamicProxyDemo2.java:49)
	at typeinfo.exercise.$Proxy0.toString(Unknown Source)
	at typeinfo.exercise.DynamicProxyHandler2.invoke(E23_SimpleDynamicProxyDemo2.java:49)
	at typeinfo.exercise.$Proxy0.toString(Unknown Source)
	at typeinfo.exercise.DynamicProxyHandler2.invoke(E23_SimpleDynamicProxyDemo2.java:49)
 */
