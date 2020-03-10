package typeinfo.exercise;

import static net.mindview.util.Print.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 在这里，我们集中了方法调用的时间度量，以前分散在代理的所有方法中。
 * created at 2020-03-10 07:42
 * @author lerry
 */
class E22_SimpleDynamicProxyDemo {
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
				new DynamicProxyHandler(real));
		consumer(proxy);
	}
}

class DynamicProxyHandler implements InvocationHandler {
	private Object proxied;

	public DynamicProxyHandler(Object proxied) {
		this.proxied = proxied;
	}

	@Override
	public Object
	invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		printlnf("\t****invoke方法的参数打印如下： \nproxy.getClass():%s \n method: %s\nargs:%s", proxy.getClass(), method, Arrays.toString(args));
		if (args != null) {
			for (Object arg : args) {
				System.out.println("  " + arg);
			}
		}
		long start = System.nanoTime();
		Object ret = method.invoke(proxied, args);
		long duration = System.nanoTime() - start;
		System.out.println("METHOD-CALL TIME: " + duration);
		return ret;
	}
}

