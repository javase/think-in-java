package think.in.java.holding.exercise;

import static net.mindview.util.Print.print;

import java.util.*;

class IDClass {
	private static int counter;

	private int count = counter++;

	@Override
	public String toString() {
		return "IDClass " + count;
	}
}

public class E07_TestList {
	public static void main(String args[]) {
		IDClass[] idc = new IDClass[10];
		for (int i = 0; i < idc.length; i++) {
			idc[i] = new IDClass();
		}
		List<IDClass> lst = new ArrayList<IDClass>(
				Arrays.asList(idc));
		print("lst = " + lst);
		List<IDClass> subSet = lst.subList(lst.size() / 4, lst.size() / 2);
		// The semantics of the sub list become undefined if the
		print("subSet = " + subSet);
		// backing list is structurally modified!
		//! lst.removeAll(subSet);
		ArrayList<IDClass> newSub = new ArrayList<IDClass>(subSet);
		lst.removeAll(subSet);
		print(newSub);
		// 直接操作 subSet 会报异常：ConcurrentModificationException
//		!print(subSet);

		print("lst = " + lst);
	}
}