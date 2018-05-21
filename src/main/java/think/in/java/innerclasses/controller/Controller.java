//: innerclasses/controller/Controller.java
// The reusable framework for control systems.
package think.in.java.innerclasses.controller;

import java.util.*;

import net.mindview.util.DateUtils;

public class Controller {
	// A class from java.util to hold BaseEvent objects:
	private List<BaseEvent> eventList = new ArrayList<BaseEvent>();

	public void addEvent(BaseEvent c) {
		eventList.add(c);
	}

	/**
	 * 寻找就绪的、要运行的事件。
	 * 找到后，调用对象的toString打印其信息，调用action方法，然后从队列中移除此事件
	 */
	public void run() {
		int i = 0;

		/**
		 * 监听事件
		 */
		while (eventList.size() > 0)
		// Make a copy so you're not modifying the list
		// while you're selecting the elements in it:
		{
			for (BaseEvent e : new ArrayList<BaseEvent>(eventList)) {
				++i;
				if (e.ready()) {
					System.out.println(String.format("%s-%s", DateUtils.getNowDateStr("yyyy-MM-dd HH:mm:ss"), e.toString()));
					// 此时你并不知道Event到底做了什么  使变化的事物与不变的事物相互分离
					e.action();
					eventList.remove(e);
				}
//				System.out.println(String.format("第%d次进入for", i));
			}
		}
		System.out.println(String.format("共监听事件%d次", i));
	}
} ///:~
