package holding;//: holding/InterfaceVsIterator.java

import typeinfo.pets.*;

import java.util.*;

public class InterfaceVsIterator {

	/**
	 * Collection接口继承了 Iterator接口
	 * @param it
	 */
	public static void display(Iterator<Pet> it) {
		while (it.hasNext()) {
			Pet p = it.next();
			System.out.print(p.id() + ":" + p + " ");
		}
		System.out.println();
	}

	/**
	 * @param pets
	 * @see java.util.List 和
	 * @see java.util.Set 接口直接集成了Collection接口，包含的元素可以通过for直接遍历
	 */
	public static void display(Collection<Pet> pets) {
		for (Pet p : pets) {
			System.out.print(p.id() + ":" + p + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		List<Pet> petList = Pets.arrayList(8);
		Set<Pet> petSet = new HashSet<Pet>(petList);
		Map<String, Pet> petMap =
				new LinkedHashMap<String, Pet>();
		String[] names = ("Ralph, Eric, Robin, Lacey, " +
				"Britney, Sam, Spot, Fluffy").split(", ");
		for (int i = 0; i < names.length; i++) {
			petMap.put(names[i], petList.get(i));
		}

		display(petList);
		display(petSet);

		display(petList.iterator());
		display(petSet.iterator());

		System.out.println("Map对象打印：");
		System.out.println(petMap);
		System.out.println("Map keySet打印：");
		System.out.println(petMap.keySet());

		System.out.println("Map值打印：");
		display(petMap.values());
		display(petMap.values().iterator());
	}
} /* Output:
0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx
4:Pug 6:Pug 3:Mutt 1:Manx 5:Cymric 7:Manx 2:Cymric 0:Rat
0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx
4:Pug 6:Pug 3:Mutt 1:Manx 5:Cymric 7:Manx 2:Cymric 0:Rat
{Ralph=Rat, Eric=Manx, Robin=Cymric, Lacey=Mutt, Britney=Pug, Sam=Cymric, Spot=Pug, Fluffy=Manx}
[Ralph, Eric, Robin, Lacey, Britney, Sam, Spot, Fluffy]
0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx
0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx
*///:~
