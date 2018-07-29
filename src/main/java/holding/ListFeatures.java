package holding;//: holding/ListFeatures.java

import typeinfo.pets.*;

import java.util.*;

import static net.mindview.util.Print.*;

public class ListFeatures {
	public static void main(String[] args) {
		Random rand = new Random(47);
		List<Pet> pets = Pets.arrayList(7);
		print("1: " + pets);
		Hamster h = new Hamster();
		// Automatically resizes
		pets.add(h);
		print("2: " + pets);
		print("3: 判断某对象是否存在于列表中：" + pets.contains(h));
		// Remove by object
		pets.remove(h);
		Pet p = pets.get(2);
		print("4: 查看某对象在列表的某个位置：" + p + " " + pets.indexOf(p));
		Pet cymric = new Cymric();
		print("5: 添加一个新Cymric对象，寻找新对象的下标：" + pets.indexOf(cymric));
		print("6: 移除新对象的结果为：" + pets.remove(cymric));
		// Must be the exact object:
		print("7: " + pets.remove(p));
		print("8: 移除下标为2的对象：" + pets);
		// Insert at an index
		pets.add(3, new Mouse());
		print("9: 在下标3位置插入Mouse对象：" + pets);
		List<Pet> sub = pets.subList(1, 4);
		print("subList(1, 4): " + sub);
		sub.set(1, new Rat());
		print("pets: (对subList()返回列表的修改都会反映到初始列表中)" + pets);
		print("10: " + pets.containsAll(sub));
		// In-place sort
		Collections.sort(sub);
		print("sorted subList: " + sub);
		// Order is not important in containsAll():
		print("11: " + pets.containsAll(sub));
		// Mix it up
		Collections.shuffle(sub, rand);
		print("shuffled subList: " + sub);
		print("12: " + pets.containsAll(sub));

		List<Pet> copy = new ArrayList<Pet>(pets);
		sub = Arrays.asList(pets.get(1), pets.get(4));
		print("sub: " + sub);
		copy.retainAll(sub);
		print("13: retainAll交集的操作：" + copy);
		// Get a fresh copy
		copy = new ArrayList<Pet>(pets);
		// Remove by index
		print(pets);
		copy.remove(2);
		print("14: 通过下标(2)删除元素：" + copy);
		// Only removes exact objects
		copy.removeAll(sub);
		print("15: " + copy);
		// Replace an element
		print(copy);
		copy.set(1, new Mouse());
		// replace比set命名显得更加合适
		print("16: set(1, new Mouse()):" + copy);
		// Insert a list in the middle
		copy.addAll(2, sub);
		print("17: " + copy);
		print("18: pets.isEmpty():" + pets.isEmpty());
		pets.clear(); // Remove all elements
		print("19: " + pets);
		print("20: " + pets.isEmpty());
		pets.addAll(Pets.arrayList(4));
		print("21: " + pets);
		Object[] o = pets.toArray();
		print("22: " + o[3]);
		Pet[] pa = pets.toArray(new Pet[0]);
		print("23: " + pa[3].id());
	}
} /* Output:
1: [Rat, Manx, Cymric, Mutt, Pug, Cymric, Pug]
2: [Rat, Manx, Cymric, Mutt, Pug, Cymric, Pug, Hamster]
3: true
4: Cymric 2
5: -1
6: false
7: true
8: [Rat, Manx, Mutt, Pug, Cymric, Pug]
9: [Rat, Manx, Mutt, Mouse, Pug, Cymric, Pug]
subList: [Manx, Mutt, Mouse]
10: true
sorted subList: [Manx, Mouse, Mutt]
11: true
shuffled subList: [Mouse, Manx, Mutt]
12: true
sub: [Mouse, Pug]
13: [Mouse, Pug]
14: [Rat, Mouse, Mutt, Pug, Cymric, Pug]
15: [Rat, Mutt, Cymric, Pug]
16: [Rat, Mouse, Cymric, Pug]
17: [Rat, Mouse, Mouse, Pug, Cymric, Pug]
18: false
19: []
20: true
21: [Manx, Cymric, Rat, EgyptianMau]
22: EgyptianMau
23: 14
*///:~
