package holding.exercise;

import static net.mindview.util.Print.*;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * created at 2019-04-08 18:28
 * @author lerry
 */
public class E28_PriorityQueue {

	public static void printQ(Queue queue) {
		print("打印队列的值：");
		while (queue.peek() != null) {
			print(queue.poll());
		}
	}

	public static void main(String[] args) {

		Random random = new Random(20);

		PriorityQueue<Double> priorityQueue = new PriorityQueue();

		for (int i = 0; i < 2; i++) {
			Double value = random.nextDouble();
			priorityQueue.offer(value);
		}

		printlnf("队列中元素总个数为：%s", priorityQueue.size());
		printQ(priorityQueue);
		printlnf("队列中元素总个数为：%s", priorityQueue.size());
	}
}
