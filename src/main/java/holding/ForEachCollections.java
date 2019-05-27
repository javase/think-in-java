package holding;//: holding/ForEachCollections.java
// All collections work with foreach.

import java.util.*;

/**
 * foreach可以和Collection对象一起工作
 */
public class ForEachCollections {
	public static void main(String[] args) {
		Collection<String> cs = new LinkedList<String>();
		Collections.addAll(cs, "Take the long way home".split(" "));
		for (String s : cs) {
			System.out.print("'" + s + "' ");
		}
	}
} /* Output:
'Take' 'the' 'long' 'way' 'home'
*///:~
