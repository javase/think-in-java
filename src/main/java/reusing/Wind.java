package reusing;//: reusing/Wind.java
// Inheritance & upcasting.

import static net.mindview.util.Print.*;

class Instrument {
    public void play() {
        printf("这里是Instrument.play方法，类名是：%s", this.getClass().getName());
    }

    static void tune(Instrument i) {
        // ...
        i.play();
    }
}

// Wind objects are instruments
// because they have the same interface:
public class Wind extends Instrument {
    public static void main(String[] args) {
        Wind flute = new Wind();
        Instrument.tune(flute); // Upcasting
    }
} ///:~
