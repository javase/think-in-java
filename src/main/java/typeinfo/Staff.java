package typeinfo;//: typeinfo/Staff.java

import java.util.ArrayList;

/**
 * 14.8 空对象：
 * 可以查询空对象，继承了ArrayList类
 * created at 2020-03-11 07:23
 * @author lerry
 */
public class Staff extends ArrayList<Position> {
	public void add(String title, Person person) {
		add(new Position(title, person));
	}

	public void add(String... titles) {
		for (String title : titles) {
			add(new Position(title));
		}
	}

	public Staff(String... titles) {
		add(titles);
	}

	/**
	 * 职位是否可用
	 * @param title
	 * @return
	 */
	public boolean positionAvailable(String title) {
		for (Position position : this) {
			if (position.getTitle().equals(title) &&
					position.getPerson() == Person.NULL) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 填补位置（职位空缺）
	 * @param title
	 * @param hire
	 */
	public void fillPosition(String title, Person hire) {
		for (Position position : this) {
			if (position.getTitle().equals(title) &&
					position.getPerson() == Person.NULL) {
				position.setPerson(hire);
				return;
			}
		}
		throw new RuntimeException(
				"Position " + title + " not available");
	}

	public static void main(String[] args) {
		Staff staff = new Staff("President", "CTO",
				"Marketing Manager", "Product Manager",
				"Project Lead", "Software Engineer",
				"Software Engineer", "Software Engineer",
				"Software Engineer", "Test Engineer",
				"Technical Writer");
		staff.fillPosition("President",
				new Person("Me", "Last", "The Top, Lonely At"));
		staff.fillPosition("Project Lead",
				new Person("Janet", "Planner", "The Burbs"));
		if (staff.positionAvailable("Software Engineer")) {
			staff.fillPosition("Software Engineer",
					new Person("Bob", "Coder", "Bright Light City"));
		}
		System.out.println(staff);
	}
} /* Output:	
[Position: President Person: Me Last The Top, Lonely At, Position: CTO NullPerson, Position: Marketing Manager NullPerson, Position: Product Manager NullPerson, Position: Project Lead Person: Janet Planner The Burbs, Position: Software Engineer Person: Bob Coder Bright Light City, Position: Software Engineer NullPerson, Position: Software Engineer NullPerson, Position: Software Engineer NullPerson, Position: Test Engineer NullPerson, Position: Technical Writer NullPerson]
*///:~
