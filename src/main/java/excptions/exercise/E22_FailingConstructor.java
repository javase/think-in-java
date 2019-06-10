package excptions.exercise;

class ConstructionException extends Exception {
}

class FailingConstructor {

	FailingConstructor(boolean fail)
			throws ConstructionException {
		if (fail) {
			throw new ConstructionException();
		}
	}
}

/**
 * 这个程序显示了施工过程的成功和失败
 * 不管构造是否成功，都确保不会出现故障。（异常都被捕获了）
 */
public class E22_FailingConstructor {
	public static void main(String args[]) {

		for (boolean b = false; ; b = !b) {
			try {
				System.out.println("Constructing...");
				FailingConstructor fc = new FailingConstructor(b);
				try {
					System.out.println("Processing...");
				}
				finally {
					System.out.println("Cleanup...");
				}
			}
			catch (ConstructionException e) {
				System.out.println("Construction has failed: " + e);
				break;
			}
		}
	}
}