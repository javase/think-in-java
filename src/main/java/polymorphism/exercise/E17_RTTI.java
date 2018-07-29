package polymorphism.exercise;

/**
 * 多态-向下转型测试；同级别类型转型测试；
 * Created by limenghua on 2017/10/31.
 * @author limenghua
 */
public class E17_RTTI {
	public static void main(String[] args) {
		Cycle[] cycles = new Cycle[] {new Unicycle(),
				new Bicycle(), new Tricycle()};
		// Compile time: method not found in Cycle:
		// cycles[0].balance();
		// cycles[1].balance();
		// cycles[2].balance();
		((Unicycle) cycles[0]).balance();  // Downcast/RTTI
		((Bicycle) cycles[1]).balance();   // Downcast/RTTI
		// polymorphism.exercise.Tricycle cannot be cast to polymorphism.exercise.Unicycle
		// 就算Tricycle类中，有着和Unicycle一样的方法，也会抛异常，因为有一些方法不是从基类继承的
		// 就算都是从基类继承的，也不能这样横向转型		((Unicycle) cycles[2]).balance();  // Exception thrown
	}
}
