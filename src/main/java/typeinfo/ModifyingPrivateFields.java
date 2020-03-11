package typeinfo;//: typeinfo/ModifyingPrivateFields.java

import static net.mindview.util.Print.*;

import java.lang.reflect.Field;

/**
 * 14.9 接口与类型信息
 * created at 2020-03-12 07:26
 * @author lerry
 */
public class ModifyingPrivateFields {
	public static void main(String[] args) throws Exception {
		WithPrivateFinalField pf = new WithPrivateFinalField();
		// System.out.println(pf);
		printlnf("类信息打印：%s", pf);

		Field f = pf.getClass().getDeclaredField("i");
		f.setAccessible(true);
		System.out.println("通过反射获取int私有域：f.getInt(pf): " + f.getInt(pf));

		f.setInt(pf, 47);
		// System.out.println(pf);
		printlnf("修改了int私有域的值之后的类信息：%s", pf);

		f = pf.getClass().getDeclaredField("s");
		f.setAccessible(true);
		System.out.println("\n通过反射获取String私有域：f.get(pf): " + f.get(pf));
		// 修改s属性的值
		f.set(pf, "No, you're not!");
		printlnf("修改final String 域的值为：%s", "No, you're not!");
		// System.out.println(pf);
		printlnf("修改了final String域的值之后的类信息：%s", pf);

		f = pf.getClass().getDeclaredField("s2");
		f.setAccessible(true);
		System.out.println("\n通过反射获取String私有域(s2)的值：f.get(pf): " + f.get(pf));
		f.set(pf, "No, you're not!");
		printlnf("修改String 域的值为：%s", "No, you're not!");
		// System.out.println(pf);
		printlnf("修改了String域的值之后的类信息：%s", pf);
	}
}

class WithPrivateFinalField {

	/**
	 * 私有域
	 */
	private int i = 1;

	/**
	 * 私有的、final修饰的域
	 */
	private final String s = "I'm totally safe";

	/**
	 * 私有域
	 */
	private String s2 = "Am I safe?";

	@Override
	public String toString() {
		return "i = " + i + ", " + s + ", " + s2;
	}
}

 /* Output:
i = 1, I'm totally safe, Am I safe?
f.getInt(pf): 1
i = 47, I'm totally safe, Am I safe?
f.get(pf): I'm totally safe
i = 47, I'm totally safe, Am I safe?
f.get(pf): Am I safe?
i = 47, I'm totally safe, No, you're not!
*///:~
