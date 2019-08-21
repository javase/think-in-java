//: typeinfo/pets/Pets.java
// Facade to produce a default PetCreator.
package typeinfo.pets;

import java.util.ArrayList;

/**
 * 外观模式（Facade Pattern）隐藏系统的复杂性， 并向客户端提供了一个客户端可以访问系统的接口
 */
public class Pets {
	public static final PetCreator creator =
			new LiteralPetCreator();

	public static Pet randomPet() {
		return creator.randomPet();
	}

	public static Pet[] createArray(int size) {
		return creator.createArray(size);
	}

	public static ArrayList<Pet> arrayList(int size) {
		return creator.arrayList(size);
	}
} ///:~
