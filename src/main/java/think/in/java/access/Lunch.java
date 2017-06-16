package think.in.java.access;//: access/Lunch.java
// Demonstrates class access specifiers. Make a class
// effectively private with private constructors:

class Soup1 {
    private Soup1() {
        System.out.println("Soup1无参构造方法");
    }

    // (1) Allow creation via static method:

    /**
     * 可以记录创建了多少个Soup1对象
     *
     * @return
     */
    public static Soup1 makeSoup() {
        return new Soup1();
    }
}

class Soup2 {
    private Soup2() {
        System.out.println("Soup2无参构造方法");
    }

    // (2) Create a static object and return a reference
    // upon request.(The "Singleton" pattern):
    private static Soup2 ps1 = new Soup2();

    public static Soup2 access() {
        return ps1;
    }

    public void f() {
    }
}

// Only one public class allowed per file:
public class Lunch {
    void testPrivate() {
        // Can't do this! Private constructor:
        //! Soup1 soup = new Soup1();
    }

    void testStatic() {
        Soup1 soup = Soup1.makeSoup();
    }

    void testSingleton() {
        Soup2.access().f();
    }

    public static void main(String[] args) {
        new Lunch().testStatic();
        new Lunch().testSingleton();
        new Lunch().testStatic();
        new Lunch().testSingleton();
        // Soup2 使用了单例模式
    }
} ///:~
