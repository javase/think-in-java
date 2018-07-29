package innerclasses.exercise;

/**
 * 内部类里面再添加内部类
 * 编译出来的class名称分别是：
 * E19_InnerInsideInner.class
 * E19_InnerInsideInner$Inner1.class
 * E19_InnerInsideInner$Inner1$Inner2.class
 * E19_InnerInsideInner$Nested1.class
 * E19_InnerInsideInner$Nested1$Nested2.class
 */
public class E19_InnerInsideInner {
	class Inner1 {
		/**
		 * 内部类中的内部类
		 */
		class Inner2 {

			void f() {
			}
		}


		Inner2 makeInner2() {
			return new Inner2();
		}
	}// end Inner1

	Inner1 makeInner1() {
		return new Inner1();
	}

	static class Nested1 {

		static class Nested2 {
			void f() {
			}
		}

		void f() {
		}
	}

	public static void main(String args[]) {
		new E19_InnerInsideInner.Nested1().f();
		new E19_InnerInsideInner.Nested1.Nested2().f();
		E19_InnerInsideInner x1 = new E19_InnerInsideInner();
//		E19_InnerInsideInner.Inner1 x2 = x1.makeInner1();
		E19_InnerInsideInner.Inner1 x2 = x1.makeInner1();
		E19_InnerInsideInner.Inner1.Inner2 x3 = x2.makeInner2();
		x3.f();
	}
} ///:~