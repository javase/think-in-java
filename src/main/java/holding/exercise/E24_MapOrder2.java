package holding.exercise;

import static net.mindview.util.Print.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

import net.mindview.util.Countries;

/**
 * 使用String填充LinkedHashMap，然后以键排序，重新插入LinkedHashMap
 * created at 2018-12-08 11:25
 * @author lerry
 */
public class E24_MapOrder2 {

	public static void main(String[] args) {
		LinkedHashMap<String, String> linkedHashMap01 = new LinkedHashMap<>(Countries.capitals(25));
		print(String.format("linkedHashMap01:%s", linkedHashMap01));

		Set<String> keys = linkedHashMap01.keySet();
		ArrayList<String> keyArrayList = new ArrayList(keys);
		print(String.format("key排序前:%s", keyArrayList));
		Collections.sort(keyArrayList);
		print(String.format("key排序后:%s", keyArrayList));

		LinkedHashMap<String, String> linkedHashMap02 = new LinkedHashMap<>();
		for (String key : keyArrayList) {
			linkedHashMap02.put(key, linkedHashMap01.get(key));
		}
		print(String.format("排序后的LinkedHashMap:%s", linkedHashMap02));

		Arrays.sort(linkedHashMap01.keySet().toArray(new String[0]));
	}

}
