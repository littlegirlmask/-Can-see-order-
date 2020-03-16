package edu.etime.yqxdc.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class Conterver implements Converter<String, Date>{

	Date date = null;
	
	@Override
	public Date convert(String str) {

		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = sdf.parse(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return date;
	}
}
