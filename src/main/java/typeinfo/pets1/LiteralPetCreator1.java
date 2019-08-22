package typeinfo.pets1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import typeinfo.pets.Cat;
import typeinfo.pets.Cymric;
import typeinfo.pets.Dog;
import typeinfo.pets.EgyptianMau;
import typeinfo.pets.Hamster;
import typeinfo.pets.Manx;
import typeinfo.pets.Mouse;
import typeinfo.pets.Mutt;
import typeinfo.pets.Pet;
import typeinfo.pets.PetCreator;
import typeinfo.pets.Pug;
import typeinfo.pets.Rat;
import typeinfo.pets.Rodent;

/**
 * 新加了Gerbil类型
 * created at 2019-08-22 12:51
 * @author lerry
 */
public class LiteralPetCreator1 extends PetCreator {
	// No try block needed.
	public static final List<Class<? extends Pet>> allTypes =
			Collections.unmodifiableList(Arrays.asList(
					Pet.class, Dog.class, Cat.class, Rodent.class,
					Mutt.class, Pug.class, EgyptianMau.class, Manx.class,
					Cymric.class, Rat.class, Mouse.class, Hamster.class,
					Gerbil.class));

	// Types for random creation:
	private static final List<Class<? extends Pet>> types =
			allTypes.subList(allTypes.indexOf(Mutt.class), allTypes.size());

	@Override
	public List<Class<? extends Pet>> types() {
		return types;
	}

	public static void main(String[] args) {
		System.out.println(types);
	}
}