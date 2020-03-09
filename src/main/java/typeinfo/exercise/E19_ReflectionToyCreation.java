package typeinfo.exercise;

import java.lang.reflect.Constructor;

class SuperToy extends FancierToy {
	int IQ;

	public SuperToy(int intelligence) {
		IQ = intelligence;
	}

	@Override
	public String toString() {
		return "I'm a SuperToy. I'm smarter than you.";
	}
}

/**
 * 使用反射机制、通过非默认构造器创建Toy对象
 */
public class E19_ReflectionToyCreation {

	/**
	 * 通过类名、和构造器的参数，来创建Toy对象
	 * @param toyName
	 * @param IQ
	 * @return
	 */
	public static Toy makeToy(String toyName, int IQ) {
		try {
			Class<?> tClass = Class.forName(toyName);
			for (Constructor<?> ctor : tClass.getConstructors()) {
				// Look for a constructor with a single parameter:
				Class<?>[] params = ctor.getParameterTypes();
				if (params.length == 1) {
					if (params[0] == int.class) {
						return (Toy) ctor.newInstance(
								new Object[] {Integer.valueOf(IQ)});
					}
				}
			}
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
		return null;
	}

	public static void main(String args[]) {
		System.out.println(makeToy("typeinfo.exercise.SuperToy", 150));
	}
} /* Output:
         I'm a SuperToy. I'm smarter than you.
         *///:~