package typeinfo;//: typeinfo/SimpleDynamicProxy.java

import static net.mindview.util.Print.*;

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
		printlnf("\t****invoke方法的参数打印如下： \nproxy.getClass():%s \n method: %s\nargs:%s", proxy.getClass(), method, Arrays.toString(args));
		if (args != null) {
			for (Object arg : args) {
				System.out.println("  " + arg);
			}
		}
		// 将请求转发给被代理的对象
		return method.invoke(proxied, args);
	}
}

 /* Output: (95% match)
真实对象的调用：
doSomething
somethingElse bonobo


动态代理对象的调用：
	****invoke方法的参数打印如下：
proxy.getClass():class typeinfo.$Proxy0
 method: public abstract void typeinfo.Interface.doSomething()
args:null
doSomething
	****invoke方法的参数打印如下：
proxy.getClass():class typeinfo.$Proxy0
 method: public abstract void typeinfo.Interface.somethingElse(java.lang.String)
args:[Ljava.lang.Object;@5b3409f
  bonobo
somethingElse bonobo
*///:~
