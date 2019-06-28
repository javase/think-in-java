package strings.exercise;

import static java.lang.String.*;

import java.util.Locale;

class DataHolder {
	int intField = 1;

	long longField = 2L;

	float floatField = 3.0f;

	double doubleField = 4.0;

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(format("%s: \n", this.getClass().getName()));
		result.append(format(Locale.US, "intField: %d\n", intField));
		result.append(format(Locale.US, "longField: %d\n", longField));
		result.append(format(Locale.US, "floatField: %.2f\n", floatField));
		result.append(format(Locale.US, "doubleField: %e\n", doubleField)); return result.toString();
	}
}

public class E06_ClassDump {
	public static void main(String[] args) {
		System.out.println(new DataHolder());
	}
}
 /* Output:
         DataHolder:
         intField: 1
         longField: 2
         floatField: 3.000000
         doubleField: 4.000000e+00
         *///:~