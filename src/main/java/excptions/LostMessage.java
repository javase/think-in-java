package excptions;//: exceptions/LostMessage.java
// How an exception can be lost.

/**
 * 异常丢失
 */
public class LostMessage {

	/**
	 * 抛出"重要的异常"
	 * @throws VeryImportantException
	 */
	public void f() throws VeryImportantException {
		throw new VeryImportantException();
	}

	/**
	 * 抛出不重要的异常
	 * @throws HoHumException
	 */
	public void dispose() throws HoHumException {
		throw new HoHumException();
	}

	public static void main(String[] args) {
		try {
			LostMessage lm = new LostMessage();
			try {
				lm.f();
			}
//			catch (Exception e){
//				Print.printlnf(e.toString());
//			}
			finally {
				lm.dispose();
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
} /* Output:
A trivial exception
*///:~
