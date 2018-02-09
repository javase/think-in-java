package think.in.java.innerclasses;

public class E02_SequenceOfStringHolders {
	public static void main(String[] args) {
		Sequence sequence = new Sequence(10);
		for (int i = 0; i < 10; i++) {
			sequence.add(new StringHolder(Integer.toString(i)));
		}
		Selector selector = sequence.getSelector();
		while (!selector.end()) {
			System.out.print(selector.current() + " ");
			selector.next();
		}
	}
}