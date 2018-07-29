package innerclasses;//: innerclasses/GreenhouseController.java
// Configure and execute the greenhouse system.
// {Args: 5000}

import innerclasses.controller.BaseEvent;

/**
 * 初始化系统
 * 添加各种不同的BaseEvent对象类配置该系统
 * 可以看到，该程序实现了一个建议的定时调度框架
 */
public class GreenhouseController {

	public static void main(String[] args) {
		GreenhouseControls gc = new GreenhouseControls();
		// Instead of hard-wiring, you could parse
		// configuration information from a text file here:

		// 添加一个响铃事件
		gc.addEvent(gc.new Bell(1));

		BaseEvent[] eventList = {
				gc.new ThermostatNight(0),
				gc.new LightOn(2),
				gc.new LightOff(2),
				gc.new WaterOn(2),
				gc.new WaterOff(2),
				gc.new ThermostatDay(3)
		};
		// 添加重启事件
		gc.addEvent(gc.new Restart(10, eventList));

		if (args.length == 1) {
			// 从启动参数中读取延时毫秒
			Integer delay = new Integer(args[0]);
			BaseEvent terminateEvent = new GreenhouseControls.Terminate(delay);
			gc.addEvent(terminateEvent);
		}
		gc.run();
	}
} /* Output:
Bing!
Thermostat on night setting
Light is on
Light is off
Greenhouse water is on
Greenhouse water is off
Thermostat on day setting
Restarting system
Terminating
*///:~
