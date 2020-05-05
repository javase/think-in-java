package functional;// functional/FunctionVariants.java
// (c)2017 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.function.DoubleFunction;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.LongFunction;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/**
 * <pre>
 * 第十三章 函数式编程 函数式接口
 * 下面枚举了基于 Lambda 表达式的所有不同 Function 变体的示例
 * 这些 Lambda 表达式尝试生成适合函数签名的最简代码。
 * 在某些情况下，有必要进行强制类型转换，否则编译器会报截断错误。
 * </pre>
 */
public class FunctionVariants {
	static Function<Foo, Bar> f1 = f -> new Bar(f);

	static IntFunction<IBaz> f2 = i -> new IBaz(i);

	static LongFunction<LBaz> f3 = l -> new LBaz(l);

	static DoubleFunction<DBaz> f4 = d -> new DBaz(d);

	static ToIntFunction<IBaz> f5 = ib -> ib.i;

	static ToLongFunction<LBaz> f6 = lb -> lb.l;

	static ToDoubleFunction<DBaz> f7 = db -> db.d;

	static IntToLongFunction f8 = i -> i;

	static IntToDoubleFunction f9 = i -> i;

	static LongToIntFunction f10 = l -> (int) l;

	static LongToDoubleFunction f11 = l -> l;

	static DoubleToIntFunction f12 = d -> (int) d;

	static DoubleToLongFunction f13 = d -> (long) d;

	/**
	 * 主方法中的每个测试都显示了 Function 接口中不同类型的 apply() 方法。
	 * 每个都产生一个与其关联的 Lambda 表达式的调用。
	 * @param args
	 */
	public static void main(String[] args) {
		Bar b = f1.apply(new Foo());
		IBaz ib = f2.apply(11);
		LBaz lb = f3.apply(11);
		DBaz db = f4.apply(11);
		int i = f5.applyAsInt(ib);
		long l = f6.applyAsLong(lb);
		double d = f7.applyAsDouble(db);
		l = f8.applyAsLong(12);
		d = f9.applyAsDouble(12);
		i = f10.applyAsInt(12);
		d = f11.applyAsDouble(12);
		i = f12.applyAsInt(13.0);
		l = f13.applyAsLong(13.0);
	}
}

/**
 * <pre>
 * 在计算机程序设计与计算机技术的相关文档中，术语foobar是一个常见的无名氏化名，
 * 常被作为“伪变量”使用。
 * 从技术上讲，“foobar”很可能在1960年代至1970年代初通过迪吉多的系统手册传播开来。
 * </pre>
 */
class Foo {
}

class Bar {
	Foo f;

	Bar(Foo f) {
		this.f = f;
	}
}

class IBaz {
	int i;

	IBaz(int i) {
		this.i = i;
	}
}

class LBaz {
	long l;

	LBaz(long l) {
		this.l = l;
	}
}

class DBaz {
	double d;

	DBaz(double d) {
		this.d = d;
	}
}


