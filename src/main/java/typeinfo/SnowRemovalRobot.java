package typeinfo;//: typeinfo/SnowRemovalRobot.java

import java.util.Arrays;
import java.util.List;

/**
 * 14.8 空对象：
 * 一个扫雪机器人
 * created at 2020-03-11 07:33
 * @author lerry
 */
public class SnowRemovalRobot implements Robot {
	private String name;

	public SnowRemovalRobot(String name) {
		this.name = name;
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public String model() {
		return "SnowBot Series 11";
	}

	@Override
	public List<Operation> operations() {
		return Arrays.asList(
				new Operation() {
					@Override
					public String description() {
						return name + " can shovel snow";
					}

					/**
					 * shovel
					 *  英  [ˈʃʌvl]   美  [ˈʃʌvl]
					 * n. 铁铲；一铲的量；铲车
					 */
					@Override
					public void command() {
						System.out.println(name + " shoveling snow");
					}
				},
				new Operation() {
					/**
					 * chip：铲
					 * @return
					 */
					@Override
					public String description() {
						return name + " can chip ice";
					}

					@Override
					public void command() {
						System.out.println(name + " chipping ice");
					}
				},
				new Operation() {
					/**
					 * roof：屋顶
					 * @return
					 */
					@Override
					public String description() {
						return name + " can clear the roof";
					}

					@Override
					public void command() {
						System.out.println(name + " clearing roof");
					}
				}
		);
	}

	public static void main(String[] args) {
		Robot.Test.test(new SnowRemovalRobot("Slusher"));
	}
} /* Output:
Robot name: Slusher
Robot model: SnowBot Series 11
Slusher can shovel snow
Slusher shoveling snow
Slusher can chip ice
Slusher chipping ice
Slusher can clear the roof
Slusher clearing roof
*///:~
