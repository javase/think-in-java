package think.in.java.innerclasses.exercise;

import think.in.java.innerclasses.controller.*;

/**
 * 添加打开、关闭风扇的内部类事件
 */
class GreenhouseControlsWithFan extends Controller {

	private boolean light = false;

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

	private boolean fan = false;

	/**
	 * 打开风扇的内部类
	 */
	public class FanOn extends BaseEvent {
		public FanOn(long delayTime) {
			super(delayTime);
		}

		@Override
		public void action() {
			// Put hardware control code here to
			// physically turn on the Fan.
			fan = true;
		}

		@Override
		public String toString() {
			return "Fan is on";
		}
	}

	/**
	 * 关闭风扇的内部类
	 */
	public class FanOff extends BaseEvent {
		public FanOff(long delayTime) {
			super(delayTime);
		}

		@Override
		public void action() {
			// Put hardware control code here to
			// physically turn off the Fan.
			fan = false;
		}

		@Override
		public String toString() {
			return "Fan is off";
		}
	}

	private boolean water = false;

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

	private String thermostat = "Day";

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
	public class Bell extends BaseEvent {
		public Bell(long delayTime) {
			super(delayTime);
		}

		@Override
		public void action() {
			addEvent(new Bell(delayTime));
		}

		@Override
		public String toString() {
			return "Bing!";
		}
	}

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
}