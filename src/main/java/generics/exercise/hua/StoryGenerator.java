package generics.exercise.hua;

import static net.mindview.util.Print.*;

import java.util.Iterator;
import java.util.Random;

import net.mindview.util.Generator;

/**
 * 15.3 泛型接口
 * created at 2020-04-03 12:50
 * @author lerry
 */
public class StoryGenerator implements Iterable<StoryCharacters>, Generator<StoryCharacters> {

	public static void main(String[] args) {

		int size = 5;
		StoryGenerator storyGenerator = new StoryGenerator();
		for (int i = 0; i < size; i++) {
			printlnf(storyGenerator.next());
		}
		printALineDouble();
		for (StoryCharacters story : new StoryGenerator(size)) {
			printlnf(story);
		}
	}
	/* Output:
LuZhiShen 0 is a good guy
ZhenGuanXi 1 is a bad guy
ChaoGai 2 is a good guy
ZhenGuanXi 3 is a bad guy
ChaoGai 4 is a good guy
===========================================================================
LuZhiShen 5 is a good guy
ZhenGuanXi 6 is a bad guy
ChaoGai 7 is a good guy
ZhenGuanXi 8 is a bad guy
ChaoGai 9 is a good guy
	 *///:~

	private Class<?>[] classArray = {SongJiang.class, ChaoGai.class, LuZhiShen.class, JiangMenShen.class, XiMenQing.class, ZhenGuanXi.class};

	private Random random = new Random(47);

	/**
	 * 大小限制
	 */
	private int size;

	public StoryGenerator() {
	}

	public StoryGenerator(int size) {
		this.size = size;
	}

	@Override
	public Iterator<StoryCharacters> iterator() {
		return new StoryIterator();
	}

	@Override
	public StoryCharacters next() {
		int randomIndex = random.nextInt(classArray.length);
		StoryCharacters storyCharacter = null;
		try {
			storyCharacter = (StoryCharacters) classArray[randomIndex].newInstance();
		}
		catch (InstantiationException e) {
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return storyCharacter;
	}


	class StoryIterator implements Iterator<StoryCharacters> {

		private int count = size;

		@Override
		public boolean hasNext() {
			return count > 0;
		}

		@Override
		public StoryCharacters next() {
			count--;
			return StoryGenerator.this.next();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
