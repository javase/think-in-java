package think.in.java.innerclasses.exercise;


import think.in.java.innerclasses.controller.*;

public class E25_GreenhouseController {
	public static void main(String[] args) {
		GreenhouseControlsWithWMG gc =
				new GreenhouseControlsWithWMG();
		// Instead of hard-wiring, you could parse
		// configuration information from a text file here:
		gc.addEvent(gc.new Bell(9));
		BaseEvent[] eventList = {
				gc.new ThermostatNight(0),
				gc.new LightOn(2),
				gc.new LightOff(4),
				gc.new WaterOn(6),
				gc.new WaterOff(8),
				gc.new ThermostatDay(14),
				gc.new WatermistGeneratorOn(16),
				gc.new WatermistGeneratorOff(18)
		};
		gc.addEvent(gc.new Restart(20, eventList));
		if (args.length == 1) {
			gc.addEvent(new GreenhouseControlsWithWMG
					.Terminate(new Integer(args[0])));
		}
		gc.run();
	}
}