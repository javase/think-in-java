package typeinfo.exercise;

import static net.mindview.util.Print.*;

/**
 * 修改SweetShop.java，使每种类型的对象的创建由命令行参数，就是如果你的命令行为“java Sweetshop Candy”，然后 仅创建Candy对象。
 * 注意你是如何通过命令行参数控制加载哪些类对象
 * typeinfo.exercise.Gum typeinfo.exercise.Cookie
 * created at 2019-08-13 12:37
 * @author lerry
 */
public class E07_CommandLoad {

	public static void main(String[] args) throws ClassNotFoundException {
		for (String arg : args) {
			Class.forName(arg);
		}
	}
}


class Candy {
	static { print("Loading Candy"); }
}

class Gum {
	static { print("Loading Gum"); }
}

class Cookie {
	static { print("Loading Cookie"); }
}