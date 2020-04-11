package generics;//: generics/LimitsOfInference.java

import static net.mindview.util.Print.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.mindview.util.New;
import typeinfo.pets.Person;
import typeinfo.pets.Pet;

/**
 * 15.4.1 杠杆利用类型参数推断
 * <pre>
 * 如果你将一个泛型方法调用的结果
 * (例如New.map())作为参数，传递给另一个方法，这时编译器并不会执行类型推断。
 * 在这种情况下，编译器认为:调用泛型方法后，其返回值被赋给一个Object类型的变量。
 * </pre>
 * created at 2020-04-11 16:48
 * @author lerry
 */
public class LimitsOfInference {
	static void f(Map<Person, List<? extends Pet>> petPeople) {
	}

	static void fObj(Object object) {
		printlnf("%s", object.getClass().getName());
	}

	public static void main(String[] args) {
		// f(New.map()); // Does not compile
		Map<Person, List<? extends Pet>> petPeople = new HashMap<Person, List<? extends Pet>>();
		// 可以编译通过
		f(petPeople);

		// 可以编译通过
		Map<Person, List<? extends Pet>> petPeople02 = New.map();
		f(petPeople02);

		// 编译不通过
		// f(New.map());

		// 编译器认为:调用泛型方法后，其返回值被赋给一个Object类型的变量。
		Object obj = New.map();
		printlnf(obj.getClass().getName());

		// 编译器认为:调用泛型方法后，其返回值被赋给一个Object类型的变量。
		fObj(New.map());
	}
} ///:~
