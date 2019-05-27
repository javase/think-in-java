package holding.exercise.hua;

import static net.mindview.util.Print.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

/**
 * created at 2019-05-23 19:49
 * @author lerry
 */


class CollectionSequence3 extends PetSequence implements Collection<Pet> {

	static void display(Iterator<Pet> iterator) {
		while (iterator.hasNext()) {
			Pet pet = iterator.next();
			printlnf("%s:%s ", pet.id(), pet);
		}
	}

	static void display(Collection<Pet> pets) {
		for (Pet pet : pets) {
			printlnf("%s:%s ", pet.id(), pet);
		}
	}

	@Override
	public int size() {
		return pets.length;
	}

	@Override
	public boolean isEmpty() {
		return pets.length == 0;
	}

	@Override
	public boolean contains(Object o) {
		if (o == null) {
			return false;
		}
		for (Pet pet : pets) {
			if (o.equals(pet)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Iterator<Pet> iterator() {
		return new Iterator<Pet>() {
			private int index;

			@Override
			public boolean hasNext() {
				return index < pets.length;
			}

			@Override
			public Pet next() {
				return pets[index++];
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	@Override
	public Object[] toArray() {
		Object[] result = new Object[pets.length];
		System.arraycopy(pets, 0, result, 0, pets.length);
		return result;
	}


	@Override
	public <T> T[] toArray(T[] a) {
		if (a.length < pets.length) {
			/*
			int[] x = {length};
			等效于：
       		Array.newInstance(componentType, x);
			 */
			a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), pets.length);

		}
		T[] result = a;
		System.arraycopy(pets, 0, result, 0, pets.length);
		if (result.length > pets.length) {
			result[pets.length] = null;
		}

		return result;
	}

	@Override
	public boolean add(Pet pet) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		Iterator<?> it = c.iterator();
		while (it.hasNext()) {
			if (!contains(it.next())) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends Pet> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException();
	}
}

public class E30_CollectionSequence {
	public static void main(String[] args) {
		CollectionSequence3 collectionSequence3 = new CollectionSequence3();
		CollectionSequence3.display(collectionSequence3);
		System.out.println();
		CollectionSequence3.display(collectionSequence3.iterator());
		printlnf(Arrays.toString(collectionSequence3.toArray(new Pet[0])));
	}
}

class PetSequence {
	protected Pet[] pets = Pets.createArray(8);
}