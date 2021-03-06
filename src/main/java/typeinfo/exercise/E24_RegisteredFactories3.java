package typeinfo.exercise;

import static net.mindview.util.Print.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.mindview.util.Null;
import typeinfo.factory.Factory;

/**
 * 14.8 空对象：
 * 根据TIJ4的技术，我们使用动态代理为不同的部分创建空对象。IPart接口是注册工厂最重要的创新。注意，类层次结构的其余部分没有改变。
 * created at 2020-03-11 08:01
 * @author lerry
 */
public class E24_RegisteredFactories3 {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			IPart part = Part3.createRandom();
			// Real object
			System.out.println(part);
			// Null companion
			System.out.println(Part3.newNull(part.getClass()));
			printALine();
		}
	}
}

class NullPartProxyHandler implements InvocationHandler {
	private String nullName;

	private IPart proxied = new NPart();

	NullPartProxyHandler(Class<? extends IPart> type) {
		nullName = type.getSimpleName() + ": [Null Part]";
	}

	private class NPart implements Null, IPart {
		@Override
		public String toString() {
			return nullName;
		}
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return method.invoke(proxied, args);
	}
}

interface IPart {
}

class Part3 implements IPart {
	@Override
	public String toString() {
		return getClass().getSimpleName();
	}

	public static IPart
	newNull(Class<? extends IPart> type) {
		return (IPart) Proxy.newProxyInstance(
				IPart.class.getClassLoader(),
				new Class<?>[] {Null.class, IPart.class},
				new NullPartProxyHandler(type));
	}

	static List<Factory<IPart>> partFactories =
			new ArrayList<Factory<IPart>>();

	static {
		partFactories.add(new FuelFilter3.Factory());
		partFactories.add(new AirFilter3.Factory());
		partFactories.add(new CabinAirFilter3.Factory());
		partFactories.add(new OilFilter3.Factory());
		partFactories.add(new FanBelt3.Factory());
		partFactories.add(new PowerSteeringBelt3.Factory());
		partFactories.add(new GeneratorBelt3.Factory());
	}

	private static Random rand = new Random(47);

	public static IPart createRandom() {
		int n = rand.nextInt(partFactories.size());
		return partFactories.get(n).create();
	}
}

class Filter3 extends Part3 {
}

class FuelFilter3 extends Filter3 {
	public static class Factory
			implements typeinfo.factory.Factory<IPart> {
		@Override
		public IPart create() {
			return new FuelFilter3();
		}
	}
}

class AirFilter3 extends Filter3 {
	public static class Factory
			implements typeinfo.factory.Factory<IPart> {
		@Override
		public IPart create() {
			return new AirFilter3();
		}
	}
}

class CabinAirFilter3 extends Filter3 {
	public static class Factory
			implements typeinfo.factory.Factory<IPart> {
		@Override
		public IPart create() {
			return new CabinAirFilter3();
		}
	}
}

class OilFilter3 extends Filter3 {
	public static class Factory
			implements typeinfo.factory.Factory<IPart> {
		@Override
		public IPart create() {
			return new OilFilter3();
		}
	}
}

class Belt3 extends Part3 {
}

class FanBelt3 extends Belt3 {
	public static class Factory
			implements typeinfo.factory.Factory<IPart> {
		@Override
		public IPart create() {
			return new FanBelt3();
		}
	}
}

class GeneratorBelt3 extends Belt3 {
	public static class Factory
			implements typeinfo.factory.Factory<IPart> {
		@Override
		public IPart create() {
			return new GeneratorBelt3();
		}
	}
}

class PowerSteeringBelt3 extends Belt3 {
	public static class Factory
			implements typeinfo.factory.Factory<IPart> {
		@Override
		public IPart create() {
			return new PowerSteeringBelt3();
		}
	}
}
