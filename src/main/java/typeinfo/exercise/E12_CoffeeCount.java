package typeinfo.exercise;

import static net.mindview.util.Print.*;

import java.util.Iterator;

import generics.coffee.Coffee;
import generics.coffee.CoffeeGenerator;
import net.mindview.util.TypeCounter;

/**
 * 将第15章中的CoffeeGenerator.java类用于TypeCounter
 * created at 2019-08-22 12:53
 * @author lerry
 */
public class E12_CoffeeCount {

	public static void main(String[] args) {
		TypeCounter counter = new TypeCounter(Coffee.class);
		for (Iterator<Coffee> it = new CoffeeGenerator(20).iterator(); it.hasNext(); ) {
			Coffee coffee = it.next();
			printf("%s  ", coffee.getClass().getSimpleName());
			counter.count(coffee);
		}
		printALine();
		printlnf("counter:\n%s", counter);
	}
}
