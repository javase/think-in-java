package think.in.java.access;//: access/IceCream.java
// Demonstrates "private" keyword.

/**
 * 圣代
 */
class Sundae {
    private Sundae() {
    }

    static Sundae makeASundae() {
        return new Sundae();
    }
}

public class IceCream {
    public static void main(String[] args) {
        //! Sundae x = new Sundae();
        Sundae x = Sundae.makeASundae();
    }
} ///:~
