package think.in.java.holding;//: holding/AsListInference.java
// Arrays.asList() makes its best guess about type.

import java.util.*;

class Snow {
}

class Powder extends Snow {
}

class Light extends Powder {
}

class Heavy extends Powder {
}

class Crusty extends Snow {
}

class Slush extends Snow {
}

public class AsListInference {
	public static void main(String[] args) {
		List<Snow> snow1 = Arrays.asList(
				new Crusty(), new Slush(), new Powder());

		// Won't compile:  只可以接受Snow类型，不可以接收Powder类型
		// List<Snow> snow2 = Arrays.asList(
		//   new Light(), new Heavy());
		// Compiler says:
		// found   : java.util.List<Powder>
		// required: java.util.List<Snow>

		// Collections.addAll() doesn't get confused:  addAll可以接收Powder类型，从第一个参数中了解目标类型是什么
		List<Snow> snow3 = new ArrayList<Snow>();
		Collections.addAll(snow3, new Light(), new Heavy());

		// Give a hint using an
		// explicit type argument specification:  显式类型参数说明
		List<Snow> snow4 = Arrays.<Snow>asList(
				new Light(), new Heavy());
	}
} ///:~
