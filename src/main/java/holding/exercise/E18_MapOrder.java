package holding.exercise;

import static net.mindview.util.Print.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import net.mindview.util.Countries;

/**
 * created at 2018-09-18 10:13
 * @author lerry
 */
public class E18_MapOrder {

	public static void main(String[] args) {
		// 使用一组"国家-首都" 数据填充map，通过散列码展示。再按照键排序，把排序后的放在LinkedHashSet中
		Map<String, String> orderPreMap = new HashMap<String, String>(Countries.capitals(25));
		printlnf("%s:%s\n", "orderPreMap", orderPreMap);

		LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap();

		Set<String> keySet = orderPreMap.keySet();
		Object[] keyArrays = keySet.toArray();

		// 对键值进行排序
		Arrays.sort(keyArrays);
		for (Object key : keyArrays) {
			linkedHashMap.put(String.valueOf(key), orderPreMap.get(key));
		}
		printlnf("键值排序后%s:%s\n", "linkedHashMap", linkedHashMap);

		// 备注，Set获取数组时，可以指定数据类型
		String[] keyArrays2 = orderPreMap.keySet().toArray(new String[0]);
		printlnf("%s:%s", "指定类型的键值数组", Arrays.toString(keyArrays2));
	}
}
