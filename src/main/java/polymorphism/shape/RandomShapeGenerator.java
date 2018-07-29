//: polymorphism/shape/RandomShapeGenerator.java
// A "factory" that randomly creates shapes.
package polymorphism.shape;

import java.util.*;

public class RandomShapeGenerator {
	// 相同种子数的Random对象，相同次数生成的随机数字是完全相同的。
	// 也就是说，两个种子数相同的Random对象，第一次生成的随机数字完全相同，
	// 第二次生成的随机数字也完全相同。
	// 这点在生成多个随机数字时需要特别注意。
	private Random rand = new Random(47);

	public Shape next() {
		// 该方法的作用是生成一个随机的int值，该值介于[0,n)的区间，也就是0到n之间的随机int值，包含0而不包含n。
		int theCase = rand.nextInt(3);
		switch (theCase) {
			default:
			case 0:
				return new Circle();
			case 1:
				return new Square();
			case 2:
				return new Triangle();
		}
	}
} ///:~
