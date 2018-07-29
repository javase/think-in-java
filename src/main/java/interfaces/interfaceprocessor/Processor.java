//: interfaces/interfaceprocessor/Processor.java
package interfaces.interfaceprocessor;

// 从普通类修改成接口
public interface Processor {
	String name();

	Object process(Object input);
} ///:~
