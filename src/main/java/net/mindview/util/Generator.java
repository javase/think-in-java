//: net/mindview/util/Generator.java
// A generic interface.
package net.mindview.util;

/**
 * 一个生成器接口，用来专门创建对象，只定义一个方法。使用了泛型，确保next（）返回值是参数的类型
 * created at 2020-03-24 08:42
 * @author lerry
 */
public interface Generator<T> {
	T next();
} ///:~
