package excptions.exercise;


class VeryImportantException extends Exception {
	@Override
	public String toString() {
		return "A very important exception!";
	}
}

class HoHumException extends Exception {
	@Override
	public String toString() {
		return "A trivial exception";
	}
}

class YetAnotherException extends Exception {
	@Override
	public String toString() {
		return "Yet another exception";
	}
}

class LostMessage2 {
	void f() throws VeryImportantException {
		throw new VeryImportantException();
	}

	void dispose() throws HoHumException {
		throw new HoHumException();
	}

	void cleanup() throws YetAnotherException {
		throw new YetAnotherException();
	}
}

/**
 * 同样，外部try块使程序能够运行到完成。但是，请注意，输出中出现了YetAnotherException，而不是非常重要的exception或HoHumException。
 */
public class E18_LostMessage {
	public static void main(String[] args) {
		try {
			LostMessage2 lm = new LostMessage2();
			try {
				try {
					lm.f();
				}
				finally {
					lm.dispose();
				}
			}
			finally {
				lm.cleanup();
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}