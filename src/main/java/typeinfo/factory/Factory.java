//: typeinfo/factory/Factory.java
package typeinfo.factory;

public interface Factory<T> {
	/**
	 * T： 可以返回不同的类型
	 * @return
	 */
	T create();
} ///:~
