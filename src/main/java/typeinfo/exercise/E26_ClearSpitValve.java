package typeinfo.exercise;

import static net.mindview.util.Print.*;


/**
 * <pre>
 * 14.10 总结
 * 一种选择是将clearSpitValve()方法放入基类工具(Instrument)，但这令人困惑，
 * 因为它暗示打击乐、弦乐和电子仪器也有气阀。
 * RTTI提供更合理的解决方案，因为您可以将方法放在合适的特定类中(本例中为Wind)。
 * 同时，你可能会发现有一个更明智的解决方案-a prepareInstrument() method 放在基类。
 * 但是，您可能看不到这样的解决方案。当你第一次解决问题的时候，
 * 错误地假设您必须使用RTTI。
 * 我们将使用仪器层次结构的最后定义版本：
 * </pre>
 * created at 2020-03-13 07:08
 * @author lerry
 */
public class E26_ClearSpitValve {
	public static void main(String[] args) {
		// orchestra：管弦乐队
		Instrument[] orchestra = {
				new Wind(), new Percussion(),
				new Stringed(), new Brass(),
				new Woodwind(),
		};
		printlnf("准备所有的乐器：");
		Music5.prepareAll(orchestra);
		printlnf("为所有的乐器调音：");
		Music5.tuneAll(orchestra);
	}
}
/* Output:
准备所有的乐器：
Wind.clearSpitValve
Percussion.prepareInstrument
Stringed.prepareInstrument
Brass.clearSpitValve
Woodwind.clearSpitValve
为所有的乐器调音：
Wind.play()
Percussion.play()
Stringed.play()
Brass.play()
Woodwind.play()
*///:~

/**
 * 铜管乐器
 * created at 2020-03-13 07:19
 * @author lerry
 */
class Brass extends Wind {
	@Override
	public void play() {
		print("Brass.play()");
	}

	@Override
	public void adjust() {
		print("Brass.adjust()");
	}

	@Override
	public void clearSpitValve() {
		print("Brass.clearSpitValve");
	}
}

/**
 * n. 木管乐器
 * created at 2020-03-13 07:19
 * @author lerry
 */
class Woodwind extends Wind {
	@Override
	public void play() {
		print("Woodwind.play()");
	}

	@Override
	public String what() {
		return "Woodwind";
	}

	@Override
	public void clearSpitValve() {
		print("Woodwind.clearSpitValve");
	}
}

/**
 * 五种乐器
 * created at 2020-03-13 07:19
 * @author lerry
 */
class Music5 {
	/**
	 * 为…调音
	 * created at 2020-03-13 07:20
	 */
	static void tune(Instrument i) {
// ...
		i.play();
	}

	static void tuneAll(Instrument[] e) {
		for (Instrument instrument : e) {
			tune(instrument);
		}
	}

	/**
	 * 准备所有乐器
	 * created at 2020-03-13 07:20
	 */
	static void prepareAll(Instrument[] e) {
		for (Instrument instrument : e) {
			instrument.prepareInstrument();
		}
	}
}

/**
 * 乐器接口
 * created at 2020-03-13 07:15
 * @author lerry
 */
interface Instrument {
	void play();

	String what();

	void adjust();

	void prepareInstrument();
}

/**
 * 吹响号角
 * created at 2020-03-13 07:17
 * @author lerry
 */
class Wind implements Instrument {
	@Override
	public void play() {
		print("Wind.play()");
	}

	@Override
	public String what() {
		return "Wind";
	}

	@Override
	public void adjust() {
	}

	/**
	 * 管弦乐器需要清理气阀，其他乐器不需要
	 * created at 2020-03-13 07:17
	 */
	public void clearSpitValve() {
		print("Wind.clearSpitValve");
	}

	@Override
	public void prepareInstrument() {
		clearSpitValve();
	}
}

/**
 * 敲打乐器
 * created at 2020-03-13 07:18
 * @author lerry
 */
class Percussion implements Instrument {
	@Override
	public void play() {
		print("Percussion.play()");
	}

	@Override
	public String what() {
		return "Percussion";
	}

	@Override
	public void adjust() {
	}

	@Override
	public void prepareInstrument() {
		print("Percussion.prepareInstrument");
	}
}

/**
 * （乐器等）有弦的
 * created at 2020-03-13 07:18
 * @author lerry
 */
class Stringed implements Instrument {
	@Override
	public void play() {
		print("Stringed.play()");
	}

	@Override
	public String what() {
		return "Stringed";
	}

	@Override
	public void adjust() {
	}

	@Override
	public void prepareInstrument() {
		print("Stringed.prepareInstrument");
	}
}