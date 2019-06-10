package excptions;//: exceptions/Cleanup.java
// Guaranteeing proper cleanup of a resource.

public class Cleanup {
	public static void main(String[] args) {
		try {
			InputFile in = new InputFile("Cleanup.java");
			try {
				String s;
				int i = 1;
				while ((s = in.getLine()) != null) {
					; // Perform line-by-line processing here...
				}
			}
			catch (Exception e) {
				System.out.println("Caught Exception in main");
				e.printStackTrace(System.out);
			}
			finally {
				// 构造成功时，才可能走到这个地方
				in.dispose();
			}
		}
		catch (Exception e) {
			// InputFile对象构造过程中出现异常的话，是不需要调用dispose()方法的
			System.out.println("InputFile construction failed");
		}
	}
} /* Output:
dispose() successful
*///:~
