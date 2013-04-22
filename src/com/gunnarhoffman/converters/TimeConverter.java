package com.gunnarhoffman.converters;

import java.math.BigDecimal;

public class TimeConverter {

	public TimeConverter(BigDecimal microseconds) {
		// TODO Auto-generated constructor stub
	}

	public static TimeConverter fromMicroseconds(long microseconds) {
		return TimeConverter.fromMicroseconds(new BigDecimal(
				Long.toString(microseconds)));
	}

	public static TimeConverter fromMicroseconds(BigDecimal microseconds) {

		return new TimeConverter(microseconds);
	}

	public static TimeConverter fromMilliseconds(long milliseconds) {

		return null;
	}
}
