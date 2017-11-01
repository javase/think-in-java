package think.in.java.interfaces.music4.exercise;

/**
 * 包含抽象方法print()
 * Created by limenghua on 2017/11/1.
 * @author limenghua
 */
abstract class BaseWithPrint {
	public BaseWithPrint() {
		print();
	}

	public abstract void print();
}

class DerivedWithPrint extends BaseWithPrint {
	int i = 47;

	@Override
	public void print() {
		System.out.println("i = " + i);
	}
}

/**
 * output:
 * i = 0
 * i = 47
 * 抽象类的构造器中调用print（）时，导出类的成员变量i 被初始化为0.
 * 当导出类的构造器被调用时，i已经被初始化为47了。
 */
public class E03_Initialization {
	public static void main(String args[]) {
		DerivedWithPrint dp = new DerivedWithPrint();
		dp.print();
	}
}
