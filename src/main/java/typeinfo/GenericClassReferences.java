package typeinfo;//: typeinfo/GenericClassReferences.java

/**
 * 泛型的限定
 */
public class GenericClassReferences {
	public static void main(String[] args) {
		Class intClass = int.class;
		Class<Integer> genericIntClass = int.class;
		genericIntClass = Integer.class; // Same thing
		intClass = double.class;
//		 genericIntClass = double.class; // Illegal
	}
} ///:~
