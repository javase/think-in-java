//: net/mindview/util/ThreeTuple.java
package net.mindview.util;

/**
 * 15.2.1 一个元祖类库
 * created at 2020-03-23 07:55
 * @author lerry
 */
public class ThreeTuple<A,B,C> extends TwoTuple<A,B> {

  /**
   * 其中的元素，可以被访问，但是因为是final类型，不能被修改
   * created at 2020-03-23 07:55
   * @author lerry
   */
  public final C third;

  public ThreeTuple(A a, B b, C c) {
    super(a, b);
    third = c;
  }
  @Override
  public String toString() {
    return "(" + first + ", " + second + ", " + third +")";
  }
} ///:~
