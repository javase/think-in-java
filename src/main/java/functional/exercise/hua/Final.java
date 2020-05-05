package functional.exercise.hua;

import java.util.List;

import com.google.common.collect.ImmutableList;

/**
 * created at 2020-05-02 03:16
 * @author lerry
 */
public class Final {
	public static void main(String[] args) {

		/*
		 * 设置一次，永不改变。将值传递给函数，该函数然后生成新值但从不修改自身外部的任何东西
		 */
		int count = 0;
		List<String> list = ImmutableList.of("a", "b", "c", "d");

		list.stream()
				.forEach(s -> {
					// count++;
					// 会提示： Variable used in lambda expression should be final or effectively final
				});

	}
}
