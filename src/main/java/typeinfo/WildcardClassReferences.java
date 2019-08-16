package typeinfo;//: typeinfo/WildcardClassReferences.java

/**
 * 泛型 通配符 ?
 */
public class WildcardClassReferences {
	public static void main(String[] args) {

		// Class<Number> genericNumberClass = int.class; 会报错
		// 因为 Integer Class 对象 不是 Number Class 对象的子类
		Class<?> intClass = int.class;
		intClass = double.class;
	}
} ///:~
