package generics.exercise;

import static net.mindview.util.Print.*;

import generics.Holder3;
import typeinfo.pets.Mouse;
import typeinfo.pets.Pet;

/**
 * 练习：Mouse is a kind of Pet, so Holder3<Pet> can hold an instance of Mouse.
 * created at 2020-03-17 07:55
 * @author lerry
 */
public class E01_PetsHolder {
	public static void main(String[] args) {
//		Holder3<Pet> h3 = new Holder3<Pet>(new Mouse("Mickey"));
//		System.out.println(h3.get());
		Holder3<Pet> h3 = new Holder3<>();
		h3.set(new Mouse("mickey"));
		printlnf(h3.get());

	}
} /* Output:
Mouse Mickey
*///:~