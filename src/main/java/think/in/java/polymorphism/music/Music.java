package think.in.java.polymorphism.music;

/**
 * Created by limenghua on 2017/10/28.
 * @author limenghua
 */
public class Music {
	// 接受一个父类的引用，同时可以接收导出自Instrument的类
	public static void tune(Instrument i) {
		i.play(Note.MIDDLE_C);
	}

	public static void main(String[] args) {
		Wind flute = new Wind();
		tune(flute);
	}
}
