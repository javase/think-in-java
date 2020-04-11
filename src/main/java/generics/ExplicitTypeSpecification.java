package generics;//: generics/ExplicitTypeSpecification.java

import java.util.List;
import java.util.Map;

import net.mindview.util.New;
import typeinfo.pets.Person;
import typeinfo.pets.Pet;

/**
 * 15.4.1 杠杆利用类型参数推断 - 显式的类型说明
 * created at 2020-04-11 17:00
 * @author lerry
 */
public class ExplicitTypeSpecification {
	static void f(Map<Person, List<Pet>> petPeople) {
	}

	public static void main(String[] args) {
		f(New.<Person, List<Pet>>map());
	}
} ///:~
