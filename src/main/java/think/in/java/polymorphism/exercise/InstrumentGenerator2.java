package think.in.java.polymorphism.exercise;

class InstrumentGenerator2 {
	java.util.Random gen = new java.util.Random(47);

	Class<?> instruments[] = {
			Wind.class,
			Percussion.class,
			Stringed.class,
			Brass.class,
			Woodwind.class,
			Electronic.class,
	};

	public Instrument next() {
		try {
			// 随机返回某个位置的Instrument对象
			int idx = Math.abs(gen.nextInt(instruments.length));
			return (Instrument) instruments[idx].newInstance();
		}
		catch (Exception e) {
			throw new RuntimeException("Cannot Create", e);
		}
	}
}

