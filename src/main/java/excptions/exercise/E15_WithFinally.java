package excptions.exercise;

import excptions.OnOffException1;
import excptions.OnOffException2;
import excptions.Switch;

/**
 * 使用了finally关键字的情况，程序按照正常秩序关闭了模拟资源
 */
public class E15_WithFinally {
	static Switch sw = new Switch();

	static void f() throws OnOffException1, OnOffException2 {
		throw new RuntimeException("Inside try");
	}

	public static void main(String[] args) {
		try {
			try {
				sw.on(); // Code that can throw exceptions...
				f();
			}
			catch (OnOffException1 e) {
				System.out.println("OnOffException1");
			}
			catch (OnOffException2 e) {
				System.out.println("OnOffException2");
			}
			finally {
				sw.off();
			}
		}
		catch (RuntimeException e) {
			System.out.println("Exception '" + e +
					"'. Did the switch get turned off?");
			System.out.println(sw);
		}
	}
}