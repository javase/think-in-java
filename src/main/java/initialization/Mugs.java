package initialization;//: initialization/Mugs.java
// Java "Instance Initialization."

import static common.Print.*;

class Mug {
    Mug(int marker) {
        print("Mug无参构造器(" + marker + ")");
    }

    void f(int marker) {
        print("f(" + marker + ")");
    }
}

public class Mugs {
    Mug mug1;
    Mug mug2;

    {
        mug1 = new Mug(1);
        mug2 = new Mug(2);
        print("mug1 & mug2 initialized");
    }

    Mugs() {
        print("Mugs无参构造器()");
    }

    Mugs(int i) {
        print("Mugs一参构造器(int)");
    }

    public static void main(String[] args) {
        print("Inside main()");
        new Mugs();
        print("new Mugs() completed");
        new Mugs(1);
        print("new Mugs(1) completed");
    }
} /* Output:
Inside main()
Mug(1)
Mug(2)
mug1 & mug2 initialized
Mugs()
new Mugs() completed
Mug(1)
Mug(2)
mug1 & mug2 initialized
Mugs(int)
new Mugs(1) completed
*///:~
