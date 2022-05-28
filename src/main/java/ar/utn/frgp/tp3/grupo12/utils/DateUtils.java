package ar.utn.frgp.tp3.grupo12.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	private static final String DATE_FORMAT = "dd/MM/yyyy";

	public static Date parseFromText(String str) throws ParseException {
		return new SimpleDateFormat(DATE_FORMAT).parse(str);
	}
	
	public static String formatFromDate(Date date) {
		return new SimpleDateFormat(DATE_FORMAT).format(date);
	}
}
