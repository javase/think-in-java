package functional.exercise.hua;

import static net.mindview.util.Print.*;

/**
 * 对@FunctionalInterface注解进行测试，看标注了@FunctionalInterface的接口，是否可以拥有两个方法定义
 * created at 2020-05-05 06:29
 * @author lerry
 */
public class FunctionalInterface {

	public int methodInClass(int b) {
		return b * b;
	}

	public static void main(String[] args) {
		printlnf("如果标注了@FunctionalInterface的接口，没有定义函数，会报错：No target method found");
		printlnf("如果标注了@FunctionalInterface的接口，定义了两个函数，会报错：%s",
				"Multiple non-overriding abstract methods found in interface functional.exercise.hua.Hualnterface");

		FunctionalInterface functionalInterface = new FunctionalInterface();
		HuaInterface huaInterface = functionalInterface::methodInClass;
		int result = huaInterface.method01(10);
		printlnf("result is %s", result);
	}
}

@java.lang.FunctionalInterface
interface HuaInterface {
	int method01(int a);
//	void method02();
}