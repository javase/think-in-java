package interfaces;//: interfaces/RandVals.java
// Initializing interface fields with
// non-constant initializers.

import java.util.*;

public interface RandVals {
	/**
	 * Random类中实现的随机算法是伪随机，也就是有规则的随机。
	 * 在进行随机时，随机算法的起源数字称为种子数(seed)，
	 * 在种子数的基础上进行一定的变换，从而产生需要的随机数字。
	 * 相同种子数的Random对象，相同次数生成的随机数字是完全相同的。
	 * 也就是说，两个种子数相同的Random对象，第一次生成的随机数字完全相同，
	 * 第二次生成的随机数字也完全相同。这点在生成多个随机数字时需要特别注意。
	 */
	Random RAND = new Random(47);

	int RANDOM_INT = RAND.nextInt(10);

	long RANDOM_LONG = RAND.nextLong() * 10;

	float RANDOM_FLOAT = RAND.nextLong() * 10;

	double RANDOM_DOUBLE = RAND.nextDouble() * 10;
} ///:~
