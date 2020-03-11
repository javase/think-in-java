package typeinfo;//: typeinfo/Position.java
/**
 * 14.8 空对象：
 * 位置，位置上有Person对象
 * created at 2020-03-11 07:10
 * @author lerry
 */
class Position {
	/**
	 * 头衔
	 */
	private String title;

	private Person person;

	public Position(String jobTitle, Person employee) {
		title = jobTitle;
		person = employee;
		if (person == null) {
			person = Person.NULL;
		}
	}

	public Position(String jobTitle) {
		title = jobTitle;
		person = Person.NULL;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String newTitle) {
		title = newTitle;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person newPerson) {
		person = newPerson;
		if (person == null) {
			person = Person.NULL;
		}
	}

	@Override
	public String toString() {
		return "Position: " + title + " " + person;
	}
} ///:~
