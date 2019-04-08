package holding.exercise;

import java.util.LinkedList;
import java.util.Queue;

class Command {
    Command(String value) {
        this.value = value;
    }

    private String value;

    public void operation() {
        System.out.println(this.value);
    }
}

class SecondClass {
    private Queue queue;

    public Command fill(Command command) {
        if (queue == null) {
            queue = new LinkedList();
        }
        queue.offer(command);
        return command;
    }

    public Queue getQueue() {
        return this.queue;
    }
}

public class E27 {
    // 消耗掉queue的对象，并调用它们的operation方法
    public static void consume(Queue queue) {
        Command command = (Command) queue.poll();
        command.operation();
    }

    public static void main(String[] args) {
        Command command01 = new Command("one");
        Command command02 = new Command("two");
        SecondClass secondClass = new SecondClass();
        secondClass.fill(command01);
        secondClass.fill(command02);
        Queue queue = secondClass.getQueue();

        for (int i = 0; i <= queue.size(); i++) {
            consume(queue);
        }

    }
}
