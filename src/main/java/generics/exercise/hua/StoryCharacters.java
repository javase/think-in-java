package generics.exercise.hua;

import static net.mindview.util.Print.*;

/**
 * 15.3 泛型接口
 * 模仿Coffee示例，编写 Iterable 生成器
 * created at 2020-04-03 12:43
 * @author lerry
 */
public class StoryCharacters {

	/**
	 * 静态的
	 */
	public static long counter = 0;

	public static final long id = counter++;

	public StoryCharacters() {
		printlnf("初始化StoryCharacters对象，现在的counter计数器变量值为：[%s]", counter);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " " + id;
	}
}
