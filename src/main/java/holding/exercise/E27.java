package holding.exercise;


import java.util.LinkedList;
import java.util.Queue;

class Command01 {
    Command01(String value) {
        this.value = value;
    }

    private String value;

    public void operation() {
        System.out.println(this.value);
    }
}

class SecondClass {
    private Queue queue;

    public Command01 fill(Command01 command) {
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
        Command01 command = (Command01) queue.poll();
        command.operation();
    }

    public static void main(String[] args) {
        Command01 command01 = new Command01("one");
        Command01 command02 = new Command01("two");
        SecondClass secondClass = new SecondClass();
        secondClass.fill(command01);
        secondClass.fill(command02);
        Queue queue = secondClass.getQueue();

        // 一种遍历方法
        for (int i = 0; i <= queue.size(); i++) {
            consume(queue);
        }

    }
}
