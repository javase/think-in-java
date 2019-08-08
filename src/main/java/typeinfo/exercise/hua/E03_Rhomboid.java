package typeinfo.exercise.hua;

import static net.mindview.util.Print.*;
import static typeinfo.exercise.E01_ToyTest.*;

import polymorphism.shape.Shape;

/**
 * created at 2019-08-08 12:48
 * @author lerry
 */
public class E03_Rhomboid {
	public static void main(String[] args) {
		Class cls = null;
		try {
			cls = Class.forName("typeinfo.exercise.hua.Rhomboid");
		}
		catch (ClassNotFoundException e) {
			printlnf("类创建出错：%s", e.getMessage());
		}
		Class superclass = cls.getSuperclass();
		printInfo(superclass);
		printALine();
		try {
			Shape shape = (Shape) superclass.newInstance();
			printlnf("Rhomboid 向上转型为：%s", shape.getClass().getName());

			Rhomboid rhomboid = (Rhomboid) shape;
			printlnf("Shape 向下转型为：%s", rhomboid.getClass().getName());

		}
		catch (InstantiationException e) {
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		catch (ClassCastException e) {
			printlnf("类型转换出错：%s", e.getMessage());
		}

		printALine();
		try {
			Shape shape02 = (Shape) cls.newInstance();
			printlnf("Rhomboid 向上转型为：%s", shape02.getClass().getName());

			Rhomboid rhomboid02 = (Rhomboid) shape02;
			printlnf("Shape 向下转型为：%s", rhomboid02.getClass().getName());
		}
		catch (InstantiationException e) {
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}
}

class Rhomboid extends Shape {
	@Override
	public String toString() {
		return "Rhomboid";
	}
}
