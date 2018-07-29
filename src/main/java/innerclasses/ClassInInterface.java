package innerclasses;//: innerclasses/ClassInInterface.java
// {main: ClassInInterface$Test}

public interface ClassInInterface {
	void howdy();

	/**
	 * 接口中的内部类，可以实现其外围接口
	 */
	class Test implements ClassInInterface {
		@Override
		public void howdy() {
			System.out.println("Howdy!");
		}

		public static void main(String[] args) {
			new Test().howdy();
		}
	}
}

/* Output:
Howdy!
*///:~
