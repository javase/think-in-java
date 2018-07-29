package innerclasses;//: innerclasses/GreenhouseControls.java
// This produces a specific application of the
// control system, all in a single class. Inner
// classes allow you to encapsulate different
// functionality for each type of event.

import net.mindview.util.DateUtils;
import innerclasses.controller.BaseEvent;
import innerclasses.controller.Controller;

/**
 * light、water和thermostat 属于外部类GreenhouseControls的私有属性，内部类可以自由访问
 */
public class GreenhouseControls extends Controller {

	/**
	 * 光
	 */
	private boolean light = false;

	/**
	 * 开灯
	 */
	public class LightOn extends BaseEvent {
		public LightOn(long delayTime) {
			super(delayTime);
		}

		@Override
		public void action() {
			// Put hardware control code here to
			// physically turn on the light.
			light = true;
		}

		@Override
		public String toString() {
			return "Light is on";
		}
	}

	/**
	 * 关灯
	 */
	public class LightOff extends BaseEvent {
		public LightOff(long delayTime) {
			super(delayTime);
		}

		@Override
		public void action() {
			// Put hardware control code here to
			// physically turn off the light.
			light = false;
		}

		@Override
		public String toString() {
			return "Light is off";
		}
	}

	/**
	 * 水
	 */
	private boolean water = false;


	/**
	 * 开始浇水
	 */
	public class WaterOn extends BaseEvent {
		public WaterOn(long delayTime) {
			super(delayTime);
		}

		@Override
		public void action() {
			// Put hardware control code here.
			water = true;
		}

		@Override
		public String toString() {
			return "Greenhouse water is on";
		}
	}

	/**
	 * 关掉水龙头
	 */
	public class WaterOff extends BaseEvent {
		public WaterOff(long delayTime) {
			super(delayTime);
		}

		@Override
		public void action() {
			// Put hardware control code here.
			water = false;
		}

		@Override
		public String toString() {
			return "Greenhouse water is off";
		}
	}

	/**
	 * 温度调节器
	 */
	private String thermostat = "Day";

	/**
	 * 夜晚模式
	 */
	public class ThermostatNight extends BaseEvent {
		public ThermostatNight(long delayTime) {
			super(delayTime);
		}

		@Override
		public void action() {
			// Put hardware control code here.
			thermostat = "Night";
		}

		@Override
		public String toString() {
			return "Thermostat on night setting";
		}
	}

	/**
	 * 白天模式
	 */
	public class ThermostatDay extends BaseEvent {
		public ThermostatDay(long delayTime) {
			super(delayTime);
		}

		@Override
		public void action() {
			// Put hardware control code here.
			thermostat = "Day";
		}

		@Override
		public String toString() {
			return "Thermostat on day setting";
		}
	}

	// An example of an action() that inserts a
	// new one of itself into the event list:

	/**
	 * 响铃
	 */
	public class Bell extends BaseEvent {
		public Bell(long delayTime) {
			super(delayTime);
		}

		/**
		 * 每隔delayTime秒，就执行一次
		 */
		@Override
		public void action() {
			// 把一个新的自身加入到事件列表
			addEvent(new Bell(delayTime));
		}

		@Override
		public String toString() {
			return String.format("Bing! [%s]", DateUtils.getNowDateStr("ss"));
		}
	}

	/**
	 * 重启系统
	 */
	public class Restart extends BaseEvent {
		private BaseEvent[] eventList;

		public Restart(long delayTime, BaseEvent[] eventList) {
			super(delayTime);
			this.eventList = eventList;
			for (BaseEvent e : eventList) {
				addEvent(e);
			}
		}

		@Override
		public void action() {
			for (BaseEvent e : eventList) {
				e.start(); // Rerun each event
				addEvent(e);
			}
			start(); // Rerun this BaseEvent
			addEvent(this);
		}

		@Override
		public String toString() {
			return "Restarting system";
		}
	}

	/**
	 * 终止
	 */
	public static class Terminate extends BaseEvent {
		public Terminate(long delayTime) {
			super(delayTime);
		}

		@Override
		public void action() {
			System.exit(0);
		}

		@Override
		public String toString() {
			return "Terminating";
		}
	}
} ///:~
