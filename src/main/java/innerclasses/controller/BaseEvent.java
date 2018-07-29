//: innerclasses/controller/Event.java
// The common methods for any control event.
package innerclasses.controller;

import java.util.concurrent.TimeUnit;

public abstract class BaseEvent {

	private long eventTime;

	protected final long delayTime;

	/**
	 * 对象被创建时就会调用start()方法
	 * @param delayTime  单位：秒
	 */
	public BaseEvent(long delayTime) {
		this.delayTime = delayTime;
		start();
	}

	/**
	 * 获取当前时间
	 */
	public void start() { // Allows restarting
		// System.nanoTime() 纳秒 一秒的10亿分之一
		long seconds = TimeUnit.NANOSECONDS.toSeconds(System.nanoTime());
		eventTime = seconds + delayTime;
	}

	/**
	 * 什么时候可以运行action方法了
	 * @return
	 */
	public boolean ready() {
		long seconds = TimeUnit.NANOSECONDS.toSeconds(System.nanoTime());
		long tempTime = eventTime;
		return seconds >= tempTime;
	}

	public abstract void action();
} ///:~
