package excptions.exercise;

import excptions.LostMessage;

/**
 * 这一次，外部try块正确地报告了非常重要的异常。
 */
public class E19_GuardedLostMessage {
	void f() throws VeryImportantException {
		throw new VeryImportantException();
	}

	void dispose() throws HoHumException {
		throw new HoHumException();
	}

	public static void main(String[] args) {
		try {
			LostMessage lm = new LostMessage();
			try {
				lm.f();
			}
			finally {
				try {
					lm.dispose();
				}
				catch (excptions.HoHumException e) {
					System.out.println(e);
				}
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}