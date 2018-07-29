package holding.exercise;

import static net.mindview.util.Print.print;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class E11_IterToString {
	public static void printToStrings(Iterator<?> it) {
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}

	@SuppressWarnings("unchecked")
	public static void main(String args[]) {
		List<Collection<String>> ca =
				Arrays.<Collection<String>>asList(
						new ArrayList<String>(),
						new LinkedList<String>(),
						new HashSet<String>(),
						new TreeSet<String>());

		for (Collection<String> c : ca) {
			E04_MovieNameGenerator.fill(c);
		}
		for (Collection<String> c : ca) {
			print(c.getClass().getSimpleName() + ":-------------------------");
			printToStrings(c.iterator());
		}
	}
}