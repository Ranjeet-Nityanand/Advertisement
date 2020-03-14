package com.mohshiri.advertisement.utilities;

import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Converter {

	public static void stringToDateConverter(String date) {
		
		
		
	}
	
	public static String dateToStringConverter(Date date) {
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		return format.format(date);
		
	}
	
//	 Current Date Time===================
	
	public static Date currentDateTime() {
		try {
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(new Date());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
		Date date1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH).parse(sdf.format(calendar.getTime()));
		return date1;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
//	Current String Time ========================
	
	public static String currentStringTime() {
		try {
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(new Date());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
				return sdf.format(calendar.getTime());
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
//	 String To  Base 64 Encoder ===================
	
	public static String Base64Encoder(String data) {
		try {
		String asB64 = Base64.getEncoder().encodeToString(data.getBytes("utf-8"));
		return asB64;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
//	 Base64 String to Original String ===================
	
	public static String Base64Decoder(String data) {
		try {
			byte[] asBytes = Base64.getDecoder().decode(data);
			return new String(asBytes, "utf-8");
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
