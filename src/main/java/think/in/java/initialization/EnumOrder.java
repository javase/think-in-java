package think.in.java.initialization;//: initialization/EnumOrder.java

public class EnumOrder {
    public static void main(String[] args) {
        for (Spiciness s : Spiciness.values()) {
//            System.out.println(s + ", ordinal " + s.ordinal());
            System.out.println(String.format("%s,ordinal:%d,name:%s,getDeclaringClass:%s", s, s.ordinal(), s.name(), s.getDeclaringClass().getName()));
        }
    }
} /* Output:
NOT, ordinal 0
MILD, ordinal 1
MEDIUM, ordinal 2
HOT, ordinal 3
FLAMING, ordinal 4
*///:~
