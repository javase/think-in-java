package excptions;//: exceptions/Human.java
// Catching exception hierarchies.

/**
 * 烦恼
 */
class Annoyance extends Exception {
}

/**
 * 打喷嚏
 */
class Sneeze extends Annoyance {
}

/**
 * 使用基类异常类型，也可以捕获派生类类型的异常
 */
public class Human {
	public static void main(String[] args) {
		// Catch the exact type:
		try {
			throw new Sneeze();
		}
		catch (Sneeze s) {
			System.out.println("Caught Sneeze");
		}
		catch (Annoyance a) {
			System.out.println("Caught Annoyance");
		}

		// Catch the base type:
		try {
			throw new Sneeze();
		}
		catch (Annoyance a) {
			System.out.println("Caught Annoyance");
		}
	}
} /* Output:
Caught Sneeze
Caught Annoyance
*///:~
