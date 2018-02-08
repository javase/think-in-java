package think.in.java.innerclasses.exercise;

import static think.in.java.common.Print.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by limenghua on 2018/2/9.
 * @author limenghua
 */
public class HuaMapIterator {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 15; i++) {
			list.add(String.format("第%d个元素", i + 1));
		}

		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			print(String.format("打印：%s", iterator.next()));
		}
	}
}
