//: generics/coffee/Coffee.java
package generics.coffee;

/**
 * 15.3 泛型接口
 * created at 2020-03-24 08:38
 * @author lerry
 */
public class Coffee {
	private static long counter = 0;

	private final long id = counter++;

	@Override
	public String toString() {
		return getClass().getSimpleName() + " " + id;
	}
} ///:~
