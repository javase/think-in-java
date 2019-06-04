package excptions.exercise;

class ResumerException extends Exception {
}

class Resumer {
	static int count = 3;

	static void f() throws ResumerException {
		if (--count > 0) {
			throw new ResumerException();
		}
	}
}

/**
 * "恢复模型"，捕捉到异常后不断重复，直到异常不再抛出
 */
public class E05_Resumption {
	public static void main(String args[]) {
		while (true) {
			try {
				Resumer.f();
			}
			catch (ResumerException e) {
				System.out.println("Caught " + e);
				continue;
			}
			System.out.println("Got through...");
			break;
		}
		System.out.println("Successful execution");
	}
}