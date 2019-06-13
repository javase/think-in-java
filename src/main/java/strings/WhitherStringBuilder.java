package strings;//: strings/WhitherStringBuilder.java

/**
 * <pre>
 * 当你为一个类编写toString()方法时，如果字符串操作比较简单，那就可以信赖编译器，它会为你合理地构造最终的字符串结果。
 * 但是，如果你要在toString()方法中使用循环，那么最好自己创建一个StringBuilder对象，用它来构造最终的结果。
 * </pre>
 */
public class WhitherStringBuilder {
	/**
	 * 编译后，每经过一次循环，就会创建一个新的StringBuilder对象
	 * @param fields
	 * @return
	 */
	public String implicit(String[] fields) {
		String result = "";
		for (int i = 0; i < fields.length; i++) {
			result += fields[i];
		}
		return result;
	}

	/**
	 * 虚拟机只生成一个StringBuilder对象
	 * @param fields
	 * @return
	 */
	public String explicit(String[] fields) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < fields.length; i++) {
			result.append(fields[i]);
		}
		return result.toString();
	}
} ///:~
