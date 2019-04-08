package holding.exercise.hua;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {

    public static void main(String[] args) {
        // LinkedList implements List<E>, Deque<E>, Cloneable, java.io.Serializable
        Queue myQueue = new LinkedList();
        // offer 将一个元素插入到队尾
        myQueue.offer("添加");
        myQueue.offer("到");
        myQueue.offer("队列中");
        myQueue.offer("。");
        for (Object o : myQueue) {
            System.out.print(o);
        }
    }
}
