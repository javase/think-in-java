package typeinfo;//: typeinfo/Robot.java

import static net.mindview.util.Print.*;

import java.util.List;

import net.mindview.util.Null;

/**
 * 14.8 空对象：
 * 定义了一个名字、一个模型和一个描述Robot(机器人)行为的列表List
 * created at 2020-03-11 07:31
 * @author lerry
 */
public interface Robot {
	String name();

	String model();

	List<Operation> operations();

	class Test {
		public static void test(Robot r) {
			if (r instanceof Null) {
				System.out.println("[Null Robot]");
			}
			System.out.println("Robot name: " + r.name());
			System.out.println("Robot model: " + r.model());
			for (Operation operation : r.operations()) {
				System.out.println(operation.description());
				operation.command();
			}
			printALine();
		}
	}
} ///:~
