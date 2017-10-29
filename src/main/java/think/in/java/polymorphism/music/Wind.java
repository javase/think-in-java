package think.in.java.polymorphism.music;

/**
 * Created by limenghua on 2017/10/28.
 * @author limenghua
 */
public class Wind extends Instrument {
	@Override
	public void play(Note note) {
		System.out.println("Wind.play()\t" + note);
	}
}
