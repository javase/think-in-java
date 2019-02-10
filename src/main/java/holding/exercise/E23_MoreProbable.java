package holding.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 观察某个数字比其他数字出现的次数多
 * 发现，无论运行多少遍程序，频数分布是一致的。
 * created at 2018-10-11 15:55
 * @author lerry
 */
public class E23_MoreProbable {

	public static void main(String[] args) {

		Set<Histogram> histogramSet = new HashSet<>();
		Random random = new Random(47);

		for (int i = 0; i < 10000000; i++) {
			// 100 以内的数字
			int num = random.nextInt(100);

			Histogram histogram = new Histogram(num);

			if (histogramSet.contains(histogram)) {

				for (Histogram histogram1 : histogramSet) {
					if (histogram1.equals(histogram)) {
						histogram1.increase();
						break;
					}
				}

			}
			else {
				histogramSet.add(histogram);
			}
		}// end for


		ArrayList<Histogram> list = new ArrayList<>(histogramSet);

		Collections.sort(list);
		System.out.println("排序后：");
		for (Histogram histogram : list) {
			System.out.println(histogram);
		}
	}
}


class Histogram implements Comparable<Histogram> {

	private final Integer num;

	private Integer freq = 1;

	Histogram(Integer num) {
		this.num = num;
	}

	public void increase() {
		this.freq++;
	}

	public Integer getNum() {
		return num;
	}

	public Integer getFreq() {
		return freq;
	}


	@Override
	public int hashCode() {
		return this.num.hashCode();
	}


	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Histogram && ((Histogram) obj).getNum().equals(this.num)) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Histogram{" +
				"num=" + num +
				", freq=" + freq +
				'}';
	}

	/**
	 * 倒序排列 数值大的在前
	 * @param o
	 * @return
	 */
	@Override
	public int compareTo(Histogram o) {
		return ((Histogram) o).getFreq().compareTo(this.freq);
	}
}
