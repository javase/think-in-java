//: access/dessert/Cookie.java
// Creates a library.
package think.in.java.access.dessert;

public class Cookie {
    public Cookie() {
        System.out.println("Cookie constructor");
    }

    /**
     * 默认为包级别的访问权限
     */
    void bite() {
        System.out.println("bite");
    }
} ///:~
