package innerclasses.exercise;

import innerclasses.GreenhouseControls;

import innerclasses.controller.*;

/**
 * 添加喷水机功能
 */
class GreenhouseControlsWithWMG extends GreenhouseControls {
	private boolean generator = false;

	public class WatermistGeneratorOn extends BaseEvent {
		public WatermistGeneratorOn(long delayTime) {
			super(delayTime);
		}

		@Override
		public void action() {
			generator = true;
		}

		@Override
		public String toString() {
			return "Water mist generator is on";
		}
	}

	public class WatermistGeneratorOff extends BaseEvent {
		public WatermistGeneratorOff(long delayTime) {
			super(delayTime);
		}

		@Override
		public void action() {
			generator = false;
		}

		@Override
		public String toString() {
			return "Water mist generator is off";
		}
	}
}
