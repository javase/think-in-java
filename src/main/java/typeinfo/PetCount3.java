package typeinfo;//: typeinfo/PetCount3.java
// Using isInstance()

import static net.mindview.util.Print.*;

import java.util.LinkedHashMap;
import java.util.Map;

import net.mindview.util.MapData;
import typeinfo.pets.LiteralPetCreator;
import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

/**
 * 动态地测试对象，使用isInstance()
 * created at 2019-08-21 17:07
 * @author lerry
 */
public class PetCount3 {

	static class PetCounter  extends LinkedHashMap<Class<? extends Pet>, Integer> {

		/**
		 * 预加载LiteralPetCreator中的所有类型
		 */
		public PetCounter() {
			super(MapData.map(LiteralPetCreator.allTypes, 0));
		}

		public void count(Pet pet) {
			// Class.isInstance() eliminates instanceofs:
			for (Map.Entry<Class<? extends Pet>, Integer> pair : entrySet()) {
				if (pair.getKey().isInstance(pet)) {
					put(pair.getKey(), pair.getValue() + 1);
				}
			}
		}

		@Override
		public String toString() {
			StringBuilder result = new StringBuilder("{");
			for (Map.Entry<Class<? extends Pet>, Integer> pair
					: entrySet()) {
				result.append(pair.getKey().getSimpleName());
				result.append("=");
				result.append(pair.getValue());
				result.append(", ");
			}
			result.delete(result.length() - 2, result.length());
			result.append("}");
			return result.toString();
		}
	}

	public static void main(String[] args) {
		PetCounter petCount = new PetCounter();
		for (Pet pet : Pets.createArray(20)) {
			printnb(pet.getClass().getSimpleName() + " ");
			petCount.count(pet);
		}
		printALine(125,"=");
		print(petCount);
	}
} /* Output:
Rat Manx Cymric Mutt Pug Cymric Pug Manx Cymric Rat EgyptianMau Hamster EgyptianMau Mutt Mutt Cymric Mouse Pug Mouse Cymric
{Pet=20, Dog=6, Cat=9, Rodent=5, Mutt=3, Pug=3, EgyptianMau=2, Manx=7, Cymric=5, Rat=2, Mouse=2, Hamster=1}
*///:~
