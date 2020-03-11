package typeinfo;//: typeinfo/NullRobot.java
// Using a dynamic proxy to create a Null Object.

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.List;

import net.mindview.util.Null;

/**
 * 14.8 空对象：
 * 对每一种类型的机器人，都创建一个空对象，通过动态代理捕获
 * created at 2020-03-11 07:34
 * @author lerry
 */
public class NullRobot {
	/**
	 * 通过动态代理、创建一个空的机器人对象
	 * @param type
	 * @return
	 */
	public static Robot newNullRobot(Class<? extends Robot> type) {
		return (Robot) Proxy.newProxyInstance(
				NullRobot.class.getClassLoader(),
				new Class[] {Null.class, Robot.class},
				new NullRobotProxyHandler(type));
	}

	public static void main(String[] args) {
		Robot[] bots = {
				new SnowRemovalRobot("SnowBee"),
				newNullRobot(SnowRemovalRobot.class)
		};
		for (Robot bot : bots) {
			Robot.Test.test(bot);
		}
	}
}

/**
 * 14.8 空对象：
 * Robot 的代理类
 * created at 2020-03-11 07:35
 * @author lerry
 */
class NullRobotProxyHandler implements InvocationHandler {
	private String nullName;

	private Robot proxied = new NRobot();

	NullRobotProxyHandler(Class<? extends Robot> type) {
		nullName = type.getSimpleName() + " NullRobot";
	}

	private class NRobot implements Null, Robot {
		@Override
		public String name() {
			return nullName;
		}

		@Override
		public String model() {
			return nullName;
		}

		@Override
		public List<Operation> operations() {
			return Collections.emptyList();
		}
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return method.invoke(proxied, args);
	}
}

/* Output:
Robot name: SnowBee
Robot model: SnowBot Series 11
SnowBee can shovel snow
SnowBee shoveling snow
SnowBee can chip ice
SnowBee chipping ice
SnowBee can clear the roof
SnowBee clearing roof
[Null Robot]
Robot name: SnowRemovalRobot NullRobot
Robot model: SnowRemovalRobot NullRobot
*///:~
