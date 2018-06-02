package think.in.java.innerclasses.exercise;

import think.in.java.innerclasses.controller.*;

/**
 * 添加风扇开关的执行方法
 */
public class E24_GreenhouseInnerEvent {
	public static void main(String[] args) {
		GreenhouseControlsWithFan gc =
				new GreenhouseControlsWithFan();
		// Instead of hard-wiring, you could parse
		// configuration information from a text file here:
		gc.addEvent(gc.new Bell(9));
		BaseEvent[] eventList = {
				gc.new ThermostatNight(0),
				gc.new LightOn(2),
				gc.new FanOn(3),
				gc.new LightOff(4),
				gc.new FanOff(5),
				gc.new WaterOn(6),
				gc.new WaterOff(8),
				gc.new ThermostatDay(14)
		};
		gc.addEvent(gc.new Restart(20, eventList));
		if (args.length == 1) {
			gc.addEvent(new GreenhouseControlsWithFan
					.Terminate(new Integer(args[0])));
		}
		gc.run();
	}
} 