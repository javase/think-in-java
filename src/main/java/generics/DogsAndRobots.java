package generics;//: generics/DogsAndRobots.java
// No latent typing in Java
import static net.mindview.util.Print.*;

import typeinfo.pets.Dog;

class PerformingDog extends Dog implements Performs {
  @Override
  public void speak() { print("Woof!"); }
  @Override
  public void sit() { print("Sitting"); }
  public void reproduce() {}
}

class Robot implements Performs {
  @Override
  public void speak() { print("Click!"); }
  @Override
  public void sit() { print("Clank!"); }
  public void oilChange() {}
}	

class Communicate {
  public static <T extends Performs>
  void perform(T performer) {
    performer.speak();
    performer.sit();
  }
}

public class DogsAndRobots {
  public static void main(String[] args) {
    PerformingDog d = new PerformingDog();
    Robot r = new Robot();
    Communicate.perform(d);
    Communicate.perform(r);
  }
} /* Output:
Woof!
Sitting
Click!
Clank!
*///:~