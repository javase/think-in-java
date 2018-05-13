//: interfaces/InterfaceCollision.java
package think.in.java.interfaces;

interface I1 {
	// 不带参数、不带返回值
	void f();
}

interface I2 {
	// 带有一个int参数
	int f(int i);
}


interface I3 {
	// int 返回类型
	int f();
}

class C {
	// int 返回类型
	public int f() {
		return 1;
	}
}

class C2 implements I1, I2 {
	@Override
	public void f() {
	}

	@Override
	public int f(int i) {
		return 1;
	} // overloaded
}

class C3 extends C implements I2 {
	@Override
	public int f(int i) {
		return 1;
	} // overloaded
}

class C4 extends C implements I3 {
	// Identical, no problem:
	@Override
	public int f() {
		return 1;
	}
}

// Methods differ only by return type:
//! class C5 extends C implements I1 {}
//! interface I4 extends I1, I3 {} ///:~


