package polymorphism.exercise;

/**
 * Created by limenghua on 2017/10/31.
 * @author limenghua
 */
class AlertStatus {
	public String getStatus() {
		return "None";
	}
}

class RedAlertStatus extends AlertStatus {
	@Override
	public String getStatus() {
		return "Red";
	}

	;
}

class YellowAlertStatus extends AlertStatus {
	@Override
	public String getStatus() {
		return "Yellow";
	}

	;
}

class GreenAlertStatus extends AlertStatus {
	@Override
	public String getStatus() {
		return "Green";
	}

	;
}

class Starship {
	private AlertStatus status = new GreenAlertStatus();

	public void setStatus(AlertStatus istatus) {
		status = istatus;
	}

	@Override
	public String toString() {
		return status.getStatus();
	}
}

/**
 * 状态模式
 * 通过组合类进行设计；
 * 用继承表达行为间的差异，并用字段表达状态上的变化
 */
public class E16_Starship {
	public static void main(String args[]) {
		Starship eprise = new Starship();
		System.out.println(eprise);
		eprise.setStatus(new YellowAlertStatus());
		System.out.println(eprise);
		eprise.setStatus(new RedAlertStatus());
		System.out.println(eprise);
	}
}
