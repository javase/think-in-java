package holding.exercise;

import java.util.PriorityQueue;

class Dummy {
}

/**
 * 不允许插入不可比较的对象
 */
public class E29_PriorityQueueSubtlety {
	public static void main(String[] args) {
		PriorityQueue<Dummy> priorityQueue =
				new PriorityQueue<Dummy>();
		System.out.println("Adding 1st instance...");
		priorityQueue.offer(new Dummy());
		System.out.println("Adding 2nd instance...");
		priorityQueue.offer(new Dummy());
	}
}