package holding.exercise;

import java.util.*;

class Command {
	private final String cmd;

	Command(String cmd) {
		this.cmd = cmd;
	}

	public void operation() {
		System.out.println(cmd);
	}
}

class Producer {

	public static void produce(Queue<Command> q) {
		q.offer(new Command("load"));
		q.offer(new Command("delete"));
		q.offer(new Command("save"));
		q.offer(new Command("exit"));
	}
}

class Consumer {
	public static void consume(Queue<Command> q) {
		while (q.peek() != null) {
			q.remove().operation();
		}
	}
}

/**
 * 这个经典的生产者-消费者场景使用队列将对象从程序(生产者)的一个区域传输到另一个(消费者)，main()方法充当控制器。
 */
public class E27_CommandQueue {
	public static void main(String[] args) {
		Queue<Command> cmds = new LinkedList<Command>();
		Producer.produce(cmds);
		Consumer.consume(cmds);
	}
}