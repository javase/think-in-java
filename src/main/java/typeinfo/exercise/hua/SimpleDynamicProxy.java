package typeinfo.exercise.hua;

import static net.mindview.util.Print.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 使用动态代理模式，对SimpleProxyDemo.java 进行重新实现
 * created at 2020-03-10 06:47
 * @author lerry
 */
class SimpleDynamicProxy {
	public static void consumer(Interface iface) {
		iface.doSomething();
		iface.somethingElse("bonobo");
	}

	public static void main(String[] args) {
		RealObject real = new RealObject();

		printlnf("真实对象的调用：");
		consumer(real);
		// Insert a proxy and call again:
		/*
		loader – the class loader to define the proxy class（类加载器，通常可以从被加载的对象中获取其类加载器）
		interfaces – the list of interfaces for the proxy class to implement（希望该代理实现的接口列表，不是类或者抽象类）
		h – the invocation handler to dispatch method invocations to（InvocationHandler接口的一个实现）
		 */
		Interface proxy = (Interface) Proxy.newProxyInstance(
				Interface.class.getClassLoader(),
				new Class[] {Interface.class},
				new DynamicProxyHandler(real));
		printlnf("\n\n动态代理对象的调用：");
		consumer(proxy);
	}
}

class DynamicProxyHandler implements InvocationHandler {
	private Object proxied;

	public DynamicProxyHandler(Object proxied) {
		this.proxied = proxied;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		seeProxy(proxy);

		printlnf("\t****invoke方法的参数打印如下： \n\tproxy.getClass():%s \n\tmethod: %s\n\targs:%s", proxy.getClass(), method, Arrays.toString(args));
		if (args != null) {
			for (Object arg : args) {
				System.out.println("  " + arg);
			}
		}
		// 将请求转发给被代理的对象
		return method.invoke(proxied, args);
	}

	private void seeProxy(Object proxy) {
		printALineDouble();
		printlnf("开始观察proxy对象：");
		Class proxyClass = proxy.getClass();
		// 这些对象反映由此Class对象表示的类或接口的所有公共成员方法，包括由类或接口声明的方法以及从超类和超接口继承的方法。
		Method[] methods = proxyClass.getMethods();
		// 构造器数组
		Constructor[] ctors = proxyClass.getConstructors();

		print("\nmethods:\n");
		for (Method method : methods) {
			// print(ShowMethods.p.matcher(method.toString()).replaceAll(""));
			print(method.toString());
		}

		print("\nConstructors:\n");
		for (Constructor ctor : ctors) {
			// print(ShowMethods.p.matcher(ctor.toString()).replaceAll(""));
			print(ctor.toString());
		}
		printlnf("观察proxy对象结束");
		printALineDouble();
	}

}

