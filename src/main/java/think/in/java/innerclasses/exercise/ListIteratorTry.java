package think.in.java.innerclasses.exercise;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lerry on 2018/2/9.
 * @author lerry
 */
public class ListIteratorTry {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			list.add(String.format("第%d个元素", i + 1));
		}

		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.println(String.format("打印：%s", iterator.next()));
		}
	}
}
