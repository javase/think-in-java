package think.in.java.holding;//: holding/ListIteration.java

import static net.mindview.util.Print.print;

import java.util.*;

import think.in.java.typeinfo.pets.Pet;
import think.in.java.typeinfo.pets.Pets;

public class ListIteration {
	public static void main(String[] args) {
		List<Pet> pets = Pets.arrayList(8);

		ListIterator<Pet> it = pets.listIterator();
		while (it.hasNext()) {
			System.out.print(it.next() + ", " + it.nextIndex() +
					", " + it.previousIndex() + "; ");
			print(String.format("%s, %s, %s; ", it.next(), it.nextIndex(), it.previousIndex()));
		}
		System.out.println();
		// Backwards:
		while (it.hasPrevious()) {
			System.out.print(String.format("前一个元素的id:%s\t", it.previous().id()));
		}
		System.out.println();
		System.out.println(pets);

		it = pets.listIterator(3);

		// 进行元素替换
		while (it.hasNext()) {
			Pet nextPet = it.next();
			Pet randomPet = Pets.randomPet();
			it.set(randomPet);
			print(String.format("%s:%s", nextPet, randomPet));
		}
		System.out.println(pets);
	}
} /* Output:
Rat, 1, 0; Manx, 2, 1; Cymric, 3, 2; Mutt, 4, 3; Pug, 5, 4; Cymric, 6, 5; Pug, 7, 6; Manx, 8, 7;
7 6 5 4 3 2 1 0
[Rat, Manx, Cymric, Mutt, Pug, Cymric, Pug, Manx]
[Rat, Manx, Cymric, Cymric, Rat, EgyptianMau, Hamster, EgyptianMau]
*///:~
