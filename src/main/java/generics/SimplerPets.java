package generics;//: generics/SimplerPets.java

import java.util.List;
import java.util.Map;

import net.mindview.util.New;
import typeinfo.pets.Person;
import typeinfo.pets.Pet;

/**
 * <pre>
 * 15.4.1 杠杆利用类型参数推断
 * JDK7版本的钻石操作符(&lt;&gt;)之前，可以免去如下行代码中new HashMap后面的类型说明
 * public static Map&lt;Person, List&lt;? extends Pet&gt;&gt; petPeople = new HashMap&lt;Person, List&lt;? extends Pet&gt;&gt;();
 * </pre>
 * created at 2020-04-11 16:43
 * @author lerry
 */
public class SimplerPets {
	public static void main(String[] args) {
		Map<Person, List<? extends Pet>> petPeople = New.map();

		// Rest of the code is the same...
	}
} ///:~
