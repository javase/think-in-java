package strings;//: strings/ArrayListDisplay.java

import java.util.ArrayList;

import net.mindview.util.Print;
import typeinfo.pets.Dog;

/**
 * ArrayList.toString()，会遍历List中所包含的所有对象，调用每个元素的toString()方法。
 */
public class ArrayListDisplay {
	public static void main(String[] args) {
//		ArrayList<Coffee> coffees = new ArrayList<Coffee>();
//		for (Coffee c : new CoffeeGenerator(10)) {
//			coffees.add(c);
//		}
//		System.out.println(coffees);
		Dog dog01 = new Dog("dog 01");
		Dog dog02 = new Dog("dog 02");
		Dog dog03 = new Dog("dog 03");
		ArrayList<Dog> dogs = new ArrayList<>();
		dogs.add(dog01);
		dogs.add(dog02);
		dogs.add(dog03);
		Print.printlnf(dogs.toString());
	}
}
