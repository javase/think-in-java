package holding.exercise;

import static net.mindview.util.Print.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

import net.mindview.util.Countries;

/**
 * Repeat Exercise 18 with a HashSet and LinkedHashSet.
 * created at 2018-09-18 12:44
 * @author lerry
 */
public class E19_SetOrder {

	public static void main(String[] args) {
		HashSet<String> preOrderSet = new HashSet<String>(Countries.names(25));
		printlnf("排序前 %s:\n%s\n", "preOrderSet", preOrderSet);

		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();

		String[] keyArray = preOrderSet.toArray(new String[0]);
		// 对键值排序
		Arrays.sort(keyArray);
		for (String s : keyArray) {
			linkedHashSet.add(s);
		}
		printlnf("排序后 %s:\n%s\n", "linkedHashSet", linkedHashSet);
	}
}
