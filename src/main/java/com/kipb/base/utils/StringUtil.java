package com.kipb.base.utils;

import java.util.regex.Pattern;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author yjkim
 *
 */
@Slf4j
public class StringUtil 
{
	private static final Pattern PATTERN_MACID_IP = Pattern.compile("((\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])([.](?!$)|$)){4}");

	//YYYY-MM-DD | YYYY.MM.DD ...
	private static final Pattern PATTERN_DATE_WITH_CHARACTER = Pattern.compile("\\d{4}(-|_|\\.|\\/|:)(0[1-9]|1[012])(-|_|\\.|\\/|:)(0[1-9]|[12][0-9]|3[01])");

	// public static final String PATTERN_DATE_WITH_CHARACTERS = "\\d{4}(__SP__)(0[1-9]|1[012])(__SP__)(0[1-9]|[12][0-9]|3[01])";

	//HH:mm:ss | HH.mm.ss ...
	private static final Pattern PATTERN_TIME_WITH_CHARACTER = Pattern.compile("(0[1-9]|1[0-9]|2[0-4])(-|_|\\.|\\/|:)(0[1-9]|[1-5][0-9])(-|_|\\.|\\/|:)(0[1-9]|[1-5][0-9])");

	/**
	 * IP 패턴이 맞는지 체크한다. 
	 */
	public static Boolean checkIpPattern(String str)
	{
		if(StringUtils.isEmpty(str))
		{
			return null;
		}
		
		return PATTERN_MACID_IP.matcher(str).matches();
	}

	public static String makeString(String... params)
	{
		StringBuffer sb = new StringBuffer();
		for (String param : params)
		{
			sb.append(param);
		}
		return sb.toString();
	}

	public static String makeLikeParam(String param)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("%");
		sb.append(param);
		sb.append("%");
		return sb.toString();
	}

	public static Boolean datePatternCheck(String source)
	{
		if(StringUtils.isEmpty(source))
		{
			return null;
		}
		return PATTERN_DATE_WITH_CHARACTER.matcher(source).matches();
	}

	public static Boolean timePatternCheck(String source)
	{
		if(StringUtils.isEmpty(source))
		{
			return null;
		}
		return PATTERN_TIME_WITH_CHARACTER.matcher(source).matches();
	}
}
