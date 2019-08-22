//: net/mindview/util/TypeCounter.java
// Counts instances of a type family.
package net.mindview.util;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * 使用Class.isAssignableFrom，创建一个不局限于对 Pet 计数的通用工具。
 * <br/>
 * isAssignableFrom的解释：
 * baseType.isAssignableFrom(type) : 确定此baseType对象表示的类或接口是否与指定type参数表示的类或接口相同，或者是该类或接口的超类或超接口
 * 判断的是： baseType 是不是 type 的相同类型或者超类型
 * 示例：
 * intCls.isAssignableFrom(Number.class) :false
 * intCls.isAssignableFrom(Integer.class) :true
 * numberCls.isAssignableFrom(Integer.class) :true
 * </pre>
 * created at 2019-08-21 17:15
 * @author lerry
 */
public class TypeCounter extends HashMap<Class<?>, Integer> {

	private Class<?> baseType;

	/**
	 * 使用一个基类型进行初始化
	 * @param baseType
	 */
	public TypeCounter(Class<?> baseType) {
		this.baseType = baseType;
	}

	public void count(Object obj) {
		Class<?> objCls = obj.getClass();
		if (!baseType.isAssignableFrom(objCls)) {
			throw new RuntimeException(obj + " incorrect type: "
					+ objCls + ", should be type or subtype of "
					+ baseType);
		}
		countClass(objCls);
	}

	/**
	 * 对基类型也进行计数
	 * 递归计数
	 * @param type
	 */
	private void countClass(Class<?> type) {
		Integer quantity = get(type);
		put(type, quantity == null ? 1 : quantity + 1);
		Class<?> superClass = type.getSuperclass();
		if (superClass != null && baseType.isAssignableFrom(superClass)) {
			countClass(superClass);
		}
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("{");
		for (Map.Entry<Class<?>, Integer> pair : entrySet()) {
			result.append(pair.getKey().getSimpleName());
			result.append("=");
			result.append(pair.getValue());
			result.append(", ");
		}
		result.delete(result.length() - 2, result.length());
		result.append("}");
		return result.toString();
	}
} ///:~
