package typeinfo.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 构造器就是一种工厂方法。修改RegisteredFactories.java,使其不要使用显式的工广，
 * 而是将类对象存储到List中，并使用newInstance()来创建对象。
 * created at 2019-08-22 17:19
 * @author lerry
 */
public class E14_RegisteredFactories2 {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(Part2.createRandom());
		}
	}
}

@SuppressWarnings("unchecked")
class Part2 {
	@Override
	public String toString() {
		return getClass().getSimpleName();
	}

	static List<Class<? extends Part2>> partClasses =
			Arrays.asList(FuelFilter2.class, AirFilter2.class,
					CabinAirFilter2.class, OilFilter2.class,
					FanBelt2.class, PowerSteeringBelt2.class,
					GeneratorBelt2.class);

	private static Random rand = new Random(47);

	public static Part2 createRandom() {
		int n = rand.nextInt(partClasses.size());
		try {
			return partClasses.get(n).newInstance();
		}
		catch (InstantiationException e) {
			throw new RuntimeException(e);
		}
		catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
}

class Filter2 extends Part2 {
}

class FuelFilter2 extends Filter2 {
}

class AirFilter2 extends Filter2 {
}

class CabinAirFilter2 extends Filter2 {
}

class OilFilter2 extends Filter2 {
}

class Belt2 extends Part2 {
}

class FanBelt2 extends Belt2 {
}

class GeneratorBelt2 extends Belt2 {
}

class PowerSteeringBelt2 extends Belt2 {
}