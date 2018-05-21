package net.mindview.util;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * created at 2018-05-22 06:54
 * @author limenghua
 */
public class DateUtils {


	/**
	 * 根据给定格式格式化时间
	 *
	 * @param date
	 * @param format
	 * @return
	 */
	public static String formatDate(Date date, String format) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		return simpleDateFormat.format(date);
	}

	/**
	 * 根据指定格式获取 当前时间 字符串
	 *
	 * @param format
	 * @return
	 */
	public static String getNowDateStr(String format) {
		String nowDateStr = formatDate(new Date(), format);
		return nowDateStr;
	}

}
