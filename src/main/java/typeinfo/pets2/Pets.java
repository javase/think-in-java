package typeinfo.pets2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import typeinfo.factory.Factory;
import typeinfo.pets.Pet;
import typeinfo.pets.PetCreator;

/**
 * 使用注册工厂来实现一个新的PetCreator,并修改Pets外观，使其使用这个新的Creator而并非另外两个Creator。
 * 确保使用Pets.java的其他示例仍可以正常工作。
 */
@SuppressWarnings("unchecked")
public class Pets {
	private static class RFPetCreator extends PetCreator {
		static List<Factory<? extends Pet>> petFactories =
				Arrays.asList(new Mutt.Factory(), new Pug.Factory(),
						new EgyptianMau.Factory(), new Manx.Factory(),
						new Cymric.Factory(), new Rat.Factory(),
						new Mouse.Factory(), new Hamster.Factory());

		@Override
		public List<Class<? extends Pet>> types() {
			return null;  // Dummy value, this method is not used!
		}

		@Override
		public Pet randomPet() { // Make 1 random Pet
			int n = rand.nextInt(petFactories.size());
			return petFactories.get(n).create();
		}
	}

	private static Random rand = new Random(47);

	public static final PetCreator creator =
			new RFPetCreator();

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
                                        