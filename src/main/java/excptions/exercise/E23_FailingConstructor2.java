package excptions.exercise;

import net.mindview.util.Print;

/**
 * 一个可去除的对象
 */
class WithDispose {
	private final int id;

	public WithDispose(int id) {
		this.id = id;
	}

	void dispose() {
		Print.printlnf("WithDispose.dispose():%s", id);
	}
}

class FailingConstructor2 {
	private final WithDispose wd1, wd2;

	FailingConstructor2(boolean fail) throws ConstructionException {
		wd1 = new WithDispose(1);
		try {
			if (fail) {
				throw new ConstructionException();
			}
		}
		catch (ConstructionException e) {
			wd1.dispose();
			throw e;
		}
		// 创建第二个可去除成员对象
		wd2 = new WithDispose(2);

	}
}

/**
 * created at 2019-06-10 12:39
 * @author lerry
 */
public class E23_FailingConstructor2 {

	public static void main(String[] args) {
		for (boolean b = false; ; b = !b) {
			try {
				Print.printlnf("Constructing...");
				FailingConstructor2 fc2 = new FailingConstructor2(b);

				// 创建对象的过程中没有异常，才会继续走下面的流程
				try {
					Print.printlnf("Processing...");
				}
				finally {
					// 我们没有合适的方法来调用清理!
					Print.printlnf("Clearup...");
				}
			}
			catch (ConstructionException e) {
				Print.printlnf("Construction has failed: " + e);
				break;
			}
		}
	}
}
