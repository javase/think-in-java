package generics.exercise;

import net.mindview.util.FiveTuple;

/**
 * 15.2.1 一个元祖类库
 * 练习：不同长度的元祖
 * created at 2020-03-23 08:00
 * @author lerry
 */
public class E03_SixTuple {
	static SixTuple<Vehicle, Amphibian, String, Float, Double, Byte> a() {
		return new
				SixTuple<Vehicle, Amphibian, String, Float, Double, Byte>(
				new Vehicle(), new Amphibian(), "hi", (float) 4.7,
				1.1, (byte) 1);
	}

	public static void main(String[] args) {
		System.out.println(a());
	}
} /* Output: (75% match)
         (generics.Vehicle@de6ced, generics.Amphibian@c17164, hi,
         4.7, 1.1, 1)
         *///:~

class SixTuple<A, B, C, D, E, F> extends FiveTuple<A, B, C, D, E> {
	public final F sixth;

	public SixTuple(A a, B b, C c, D d, E e, F f) {
		super(a, b, c, d, e);
		sixth = f;
	}

	@Override
	public String toString() {
		return "(" + first + ", " + second + ", " +
				third + ", " + fourth + ", " + fifth + ", " +
				sixth + ")";
	}
}


/**
 * Amphibian：adj. 两栖类的；[车辆] 水陆两用的；具有双重性格的
 * created at 2020-03-23 07:56
 * @author lerry
 */
class Amphibian {
}

/**
 * Vehicle：n. [车辆] 车辆；工具；交通工具；运载工具；传播媒介；媒介物
 * created at 2020-03-23 07:56
 * @author lerry
 */
class Vehicle {
}