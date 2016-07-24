package com.medibidz.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private static DateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy");
public static Date stringToDate(String str){
		try {
			if(str!=null)
				return formatter.parse(str);
		} catch (ParseException e) {
						e.printStackTrace();
		}
		return null;
}
}
