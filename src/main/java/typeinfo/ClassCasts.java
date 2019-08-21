package typeinfo;//: typeinfo/ClassCasts.java

class Building {
}

class House extends Building {
}

/**
 * Java5 添加了用于Class引用的转型语法，即cast()方法，用的很少。
 * 另一个没有任何用处的新特性就是 Class.asSubclass() ，该方法允许你将一个类对象类型转为更加具体的类型
 */
public class ClassCasts {
	public static void main(String[] args) {
		Building b = new House();
		Class<House> houseType = House.class;
		House h = houseType.cast(b);
		h = (House) b; // ... or just do this.
	}
} ///:~
