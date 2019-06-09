package excptions.exercise;

import excptions.OnOffException1;
import excptions.OnOffException2;
import excptions.Switch;

/**
 * 没有使用finally关键字的情况，程序没有按照正常秩序关闭模拟资源
 */
public class E14_OnOffSwitch {
	static Switch sw = new Switch();

	static void f() throws OnOffException1, OnOffException2 {
		throw new RuntimeException("Inside try");
	}

	public static void main(String[] args) {
		try {
			try {
				sw.on();
				// Code that can throw exceptions...
				f();
				sw.off();
			}
			catch (OnOffException1 e) {
				System.out.println("OnOffException1");
				sw.off();
			}
			catch (OnOffException2 e) {
				System.out.println("OnOffException2");
				sw.off();
			}
		}
		catch (RuntimeException e) {
			System.out.println(sw);
			System.out.println("Oops! the exception '"
					+ e + "' slipped through without "
					+ "turning the switch off!");
		}
	}
}
                                    