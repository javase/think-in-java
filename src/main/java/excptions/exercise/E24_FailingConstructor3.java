package excptions.exercise;

import net.mindview.util.Print;

///**
// * 一个可去除的对象
// */
//class WithDispose {
//	private final int id;
//
//	public WithDispose(int id) {
//		this.id = id;
//	}
//
//	void dispose() {
//		Print.printlnf("WithDispose.dispose():%s", id);
//	}
//}

class FailingConstructor3 {
	private final WithDispose wd1, wd2;

	FailingConstructor3(boolean fail) throws ConstructionException {
		wd1 = new WithDispose(1);
		try {
			// “模拟”其他可能抛出异常的代码
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

	void dispose() {
		wd2.dispose();
		wd1.dispose();
	}
}

/**
 * created at 2019-06-10 12:39
 * @author lerry
 */
public class E24_FailingConstructor3 {

	public static void main(String[] args) {
		for (boolean b = false; ; b = !b) {
			try {
				Print.printlnf("Constructing...");
				FailingConstructor3 fc3 = new FailingConstructor3(b);

				// 创建对象的过程中没有异常，才会继续走下面的流程
				try {
					Print.printlnf("Processing...");
				}
				finally {
					Print.printlnf("Clearup...");
					fc3.dispose();
				}
			}
			catch (ConstructionException e) {
				Print.printlnf("Construction has failed: " + e);
				break;
			}
		}
	}
}
