package typeinfo;//: typeinfo/SelectingMethods.java
// Looking for particular methods in a dynamic proxy.

import static net.mindview.util.Print.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * created at 2020-03-10 07:25
 * @author lerry
 */
class SelectingMethods {
	public static void main(String[] args) {
		SomeMethods proxy = (SomeMethods) Proxy.newProxyInstance(
				SomeMethods.class.getClassLoader(),
				new Class[] {SomeMethods.class},
				new MethodSelector(new Implementation()));
		proxy.boring1();
		proxy.boring2();
		proxy.interesting("bonobo");
		proxy.boring3();
	}
}

/**
 * 对被代理的对象，进行筛选，只对某些特定的方法，做特别处理，其他方法则直接调用被代理对象的方法
 * created at 2020-03-10 07:27
 * @author lerry
 */
class MethodSelector implements InvocationHandler {
	private Object proxied;

	public MethodSelector(Object proxied) {
		this.proxied = proxied;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		if (method.getName().equals("interesting")) {
			printALine();
			print("Proxy detected the interesting method");
			printALine();
		}
		return method.invoke(proxied, args);
	}
}

/**
 * boring:adj. 无聊的；令人厌烦的
 * created at 2020-03-10 07:26
 * @author lerry
 */
interface SomeMethods {

	void boring1();

	void boring2();

	void interesting(String arg);

	void boring3();
}

class Implementation implements SomeMethods {
	@Override
	public void boring1() {
		print("boring1");
	}

	@Override
	public void boring2() {
		print("boring2");
	}

	@Override
	public void interesting(String arg) {
		print("interesting " + arg);
	}

	@Override
	public void boring3() {
		print("boring3");
	}
}

 /* Output:
boring1
boring2
Proxy detected the interesting method
interesting bonobo
boring3
*///:~
