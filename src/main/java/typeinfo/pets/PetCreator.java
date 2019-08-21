//: typeinfo/pets/PetCreator.java
// Creates random sequences of Pets.
package typeinfo.pets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class PetCreator {
	private Random rand = new Random(47);

	// The List of the different types of Pet to create:
	// Class<? extends Pet> 含义： 任何从Pet导出的类
	public abstract List<Class<? extends Pet>> types();
	// public abstract List<? extends Pet> types02();


	/**
	 * 随机地产生List中的索引
	 * @return
	 */
	public Pet randomPet() { // Create one random Pet
		int n = rand.nextInt(types().size());
		try {
			return types().get(n).newInstance();
		}
		catch (InstantiationException e) {
			// 实例化异常
			throw new RuntimeException(e);
		}
		catch (IllegalAccessException e) {
			// 当应用程序尝试反射性地创建实例(而不是数组)、设置或获取字段或调用方法时，会引发IllegalAccessException，
			// 但当前执行的方法无法访问指定类、字段、方法或构造函数的定义。
			throw new RuntimeException(e);
		}

	}

	/**
	 * 使用 randomPet() 填充数组
	 * @param size
	 * @return
	 */
	public Pet[] createArray(int size) {
		Pet[] result = new Pet[size];
		for (int i = 0; i < size; i++) {
			result[i] = randomPet();
		}
		return result;
	}

	/**
	 * 使用createArray() 来生成 List
	 * @param size
	 * @return
	 */
	public ArrayList<Pet> arrayList(int size) {
		ArrayList<Pet> result = new ArrayList<Pet>();
		Collections.addAll(result, createArray(size));
		return result;
	}
} ///:~
