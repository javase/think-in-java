package interfaces.diy;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

/**
 * 一个自定义的接口，可以继承多个接口。
 * 当具体类要实现该接口时，需要把多个接口的方法都给实现了。
 * created at 2018-09-17 16:16
 * @author lerry
 */
public interface MultiExtendsInterface extends Collection, Comparator {
}


class AClass implements MultiExtendsInterface {
	@Override
	public int size() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public boolean contains(Object o) {
		return false;
	}

	@Override
	public Iterator iterator() {
		return null;
	}

	@Override
	public Object[] toArray() {
		return new Object[0];
	}

	@Override
	public boolean add(Object o) {
		return false;
	}

	@Override
	public boolean remove(Object o) {
		return false;
	}

	@Override
	public boolean addAll(Collection c) {
		return false;
	}

	@Override
	public void clear() {

	}

	@Override
	public boolean retainAll(Collection c) {
		return false;
	}

	@Override
	public boolean removeAll(Collection c) {
		return false;
	}

	@Override
	public boolean containsAll(Collection c) {
		return false;
	}

	@Override
	public Object[] toArray(Object[] a) {
		return new Object[0];
	}

	@Override
	public int compare(Object o1, Object o2) {
		return 0;
	}
}

