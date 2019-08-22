package typeinfo;//: typeinfo/RegisteredFactories.java
// Registering Class Factories in the base class.

class Filter extends Part {
}

/**
 * Fuel:燃料
 */
class FuelFilter extends Filter {
	// Create a Class Factory for each specific type:
	public static class Factory implements typeinfo.factory.Factory<FuelFilter> {
		@Override
		public FuelFilter create() {
			return new FuelFilter();
		}
	}
}

class AirFilter extends Filter {
	public static class Factory
			implements typeinfo.factory.Factory<AirFilter> {
		@Override
		public AirFilter create() {
			return new AirFilter();
		}
	}
}

/**
 * Cabin:小屋 / 客舱 / 船舱
 * created at 2019-08-22 17:14
 * @author lerry
 */
class CabinAirFilter extends Filter {
	public static class Factory
			implements typeinfo.factory.Factory<CabinAirFilter> {
		@Override
		public CabinAirFilter create() {
			return new CabinAirFilter();
		}
	}
}

/**
 * Oil：n. 汽油 / 润滑油 / 油画
 * created at 2019-08-22 17:14
 * @author lerry
 */
class OilFilter extends Filter {
	public static class Factory
			implements typeinfo.factory.Factory<OilFilter> {
		@Override
		public OilFilter create() {
			return new OilFilter();
		}
	}
}

/**
 * Belt：n. 皮带 / 带 / 腰带 / 地带
 * created at 2019-08-22 17:15
 * @author lerry
 */
class Belt extends Part {
}

/**
 * Fan：n. 迷 / 风扇 / 爱好者
 * created at 2019-08-22 17:15
 * @author lerry
 */
class FanBelt extends Belt {
	public static class Factory
			implements typeinfo.factory.Factory<FanBelt> {
		@Override
		public FanBelt create() {
			return new FanBelt();
		}
	}
}

/**
 * Generator：n. 发生器 / 发电机 / 电力公司 / 生产者
 * created at 2019-08-22 17:15
 * @author lerry
 */
class GeneratorBelt extends Belt {
	public static class Factory
			implements typeinfo.factory.Factory<GeneratorBelt> {
		@Override
		public GeneratorBelt create() {
			return new GeneratorBelt();
		}
	}
}

/**
 * PowerSteering：动力转向
 * created at 2019-08-22 17:16
 * @author lerry
 */
class PowerSteeringBelt extends Belt {
	public static class Factory
			implements typeinfo.factory.Factory<PowerSteeringBelt> {
		@Override
		public PowerSteeringBelt create() {
			return new PowerSteeringBelt();
		}
	}
}

public class RegisteredFactories {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(Part.createRandom());
		}
	}
} /* Output:
GeneratorBelt
CabinAirFilter
GeneratorBelt
AirFilter
PowerSteeringBelt
CabinAirFilter
FuelFilter
PowerSteeringBelt
PowerSteeringBelt
FuelFilter
*///:~
