package think.in.java.holding.exercise;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import net.mindview.util.DateUtils;
import think.in.java.innerclasses.controller.BaseEvent;

class Controller {
	// List changed to a LinkedList:
	private List<BaseEvent> eventList = new LinkedList<BaseEvent>();

	public void addEvent(BaseEvent c) {
		eventList.add(c);
	}

	public void run() {
		while (eventList.size() > 0) {

			// 注意：这里复制了一份eventList
			List newList = new LinkedList<BaseEvent>(eventList);
			Iterator<BaseEvent> it = newList.iterator();

			while (it.hasNext()) {
				BaseEvent e = it.next();
				if (e.ready()) {
					System.out.println(String.format("%s-%s", DateUtils.getNowDateStr("yyyy-MM-dd HH:mm:ss"), e.toString()));
					e.action();
					// 从列表中移除该对象  it.remove()并没有移除eventList中的元素
					//it.remove();
					eventList.remove(e);
				}
			}// end Iterator while
		}// end while
	}
}

class GreenhouseControls extends Controller {
	private boolean light = false;

	public class LightOn extends BaseEvent {
		public LightOn(long delayTime) {
			super(delayTime);
		}

		@Override
		public void action() {
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
			light = false;
		}

		@Override
		public String toString() {
			return "Light is off";
		}
	}

	private boolean water = false;

	public class WaterOn extends BaseEvent {
		public WaterOn(long delayTime) {
			super(delayTime);
		}

		@Override
		public void action() {
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
			thermostat = "Day";
		}

		@Override
		public String toString() {
			return "Thermostat on day setting";
		}
	}

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
			return String.format("Bing! [%s]", DateUtils.getNowDateStr("ss"));
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
				e.start();
				addEvent(e);
			}
			start();
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

public class E13_GreenhouseLinkedList {
	public static void main(String[] args) {
		GreenhouseControls gc = new GreenhouseControls();
		gc.addEvent(gc.new Bell(2));

		BaseEvent[] eventList = {
				gc.new ThermostatNight(1),
				gc.new LightOn(2),
				gc.new LightOff(3),
				gc.new WaterOn(4),
				gc.new WaterOff(5),
				gc.new ThermostatDay(6)
		};
		gc.addEvent(gc.new Restart(20, eventList));
		int argsParamLength = args.length;
		int argsParam = new Integer(args[0]);
		argsParam = 10;

		if (argsParamLength == 1) {
			gc.addEvent(new GreenhouseControls.Terminate(argsParam));
		}
		gc.run();
	}
}