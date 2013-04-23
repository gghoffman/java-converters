package com.gunnarhoffman.converters;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.InvalidParameterException;

/**
 * 
 * @author gghoffman
 * 
 */
public class TimeConverter {

	// Constants

	private static final BigDecimal microsecondToMillisecond = new BigDecimal(
			"1000");
	private static final BigDecimal microsecondToSecond = new BigDecimal(
			"1000000");
	private static final BigDecimal microsecondToMinute = new BigDecimal(
			"60000000");
	private static final BigDecimal microsecondToHour = new BigDecimal(
			"3600000000");
	private static final BigDecimal microsecondToDay = new BigDecimal(
			"86400000000");
	private static final BigDecimal microsecondToWeek = new BigDecimal(
			"604800000000");

	/**
	 * Calculated using 365.242 days per year.
	 */
	private static final BigDecimal microsecondToYear = new BigDecimal(
			"31556908800000");

	// Instance fields

	private BigDecimal microseconds;

	// Constructor

	public TimeConverter(BigDecimal microseconds) {
		this.setTime(microseconds);
	}

	/**
	 * 
	 * @param microseconds
	 * @return
	 */
	public final TimeConverter setTime(BigDecimal microseconds) {
		if (microseconds.signum() == -1) {
			throw new InvalidParameterException("negative time makes no sense!");
		}
		this.microseconds = microseconds;
		return this;
	}

	// Initializers

	public static TimeConverter fromMicroseconds(long microseconds) {
		return TimeConverter.fromMicroseconds(new BigDecimal(
				Long.toString(microseconds)));
	}

	public static TimeConverter fromMicroseconds(BigDecimal microseconds) {
		return new TimeConverter(microseconds);
	}

	public static TimeConverter fromMilliseconds(long milliseconds) {
		return TimeConverter.fromMilliseconds(new BigDecimal(
				Long.toString(milliseconds)));
	}

	public static TimeConverter fromMilliseconds(BigDecimal milliseconds) {

		BigDecimal calculator = new BigDecimal(milliseconds.toString());
		calculator = calculator.multiply(TimeConverter.microsecondToMillisecond);
		return new TimeConverter(calculator);
	}

	public static TimeConverter fromSeconds(double seconds) {
		return TimeConverter.fromSeconds(new BigDecimal(
				Double.toString(seconds)));
	}

	public static TimeConverter fromSeconds(BigDecimal seconds) {

		BigDecimal calculator = new BigDecimal(seconds.toString());
		calculator = calculator.multiply(TimeConverter.microsecondToSecond);
		return new TimeConverter(calculator);
	}

	public static TimeConverter fromMinutes(double minutes) {
		return TimeConverter.fromMinutes(new BigDecimal(
				Double.toString(minutes)));
	}

	public static TimeConverter fromMinutes(BigDecimal minutes) {

		BigDecimal calculator = new BigDecimal(minutes.toString());
		calculator = calculator.multiply(TimeConverter.microsecondToMinute);
		return new TimeConverter(calculator);
	}

	public static TimeConverter fromHours(double hours) {
		return TimeConverter.fromHours(new BigDecimal(Double.toString(hours)));
	}

	public static TimeConverter fromHours(BigDecimal hours) {

		BigDecimal calculator = new BigDecimal(hours.toString());
		calculator = calculator.multiply(TimeConverter.microsecondToHour);
		return new TimeConverter(calculator);
	}

	public static TimeConverter fromDays(double days) {
		return TimeConverter.fromDays(new BigDecimal(Double.toString(days)));
	}

	public static TimeConverter fromDays(BigDecimal days) {

		BigDecimal calculator = new BigDecimal(days.toString());
		calculator = calculator.multiply(TimeConverter.microsecondToDay);
		return new TimeConverter(calculator);
	}

	public static TimeConverter fromWeeks(double weeks) {
		return TimeConverter.fromWeeks(new BigDecimal(Double.toString(weeks)));
	}

	public static TimeConverter fromWeeks(BigDecimal weeks) {

		BigDecimal calculator = new BigDecimal(weeks.toString());
		calculator = calculator.multiply(TimeConverter.microsecondToWeek);
		return new TimeConverter(calculator);
	}

	public static TimeConverter fromYears(double years) {
		return TimeConverter.fromYears(new BigDecimal(Double.toString(years)));
	}

	public static TimeConverter fromYears(BigDecimal years) {

		BigDecimal calculator = new BigDecimal(years.toString());
		calculator = calculator.multiply(TimeConverter.microsecondToYear);
		return new TimeConverter(calculator);
	}

	// Output

	public BigInteger toMicroseconds() {
		return this.microseconds.toBigInteger();
	}

	public BigDecimal toMilliseconds() {
		return this.microseconds.divide(TimeConverter.microsecondToMillisecond,
				100, BigDecimal.ROUND_HALF_UP);
	}

	public BigDecimal toSeconds() {
		return this.microseconds.divide(TimeConverter.microsecondToSecond, 100,
				BigDecimal.ROUND_HALF_UP);
	}

	public BigDecimal toMinutes() {
		return this.microseconds.divide(TimeConverter.microsecondToMinute, 100,
				BigDecimal.ROUND_HALF_UP);
	}

	public BigDecimal toHours() {
		return this.microseconds.divide(TimeConverter.microsecondToHour, 100,
				BigDecimal.ROUND_HALF_UP);
	}

	public BigDecimal toDays() {
		return this.microseconds.divide(TimeConverter.microsecondToDay, 100,
				BigDecimal.ROUND_HALF_UP);
	}

	public BigDecimal toWeeks() {
		return this.microseconds.divide(TimeConverter.microsecondToWeek, 100,
				BigDecimal.ROUND_HALF_UP);
	}

	public BigDecimal toYears() {
		return this.microseconds.divide(TimeConverter.microsecondToYear, 100,
				BigDecimal.ROUND_HALF_UP);
	}

	@Override
	public String toString() {

		if (this.microseconds.compareTo(TimeConverter.microsecondToYear) >= 0) {
			return String.format("%.2f Years", this.toYears()
													.doubleValue());

		} else if (this.microseconds.compareTo(TimeConverter.microsecondToWeek) >= 0) {
			return String.format("%.2f Weeks", this.toWeeks()
													.doubleValue());

		} else if (this.microseconds.compareTo(TimeConverter.microsecondToDay) >= 0) {
			return String.format("%.2f Days", this.toDays()
													.doubleValue());

		} else if (this.microseconds.compareTo(TimeConverter.microsecondToHour) >= 0) {
			return String.format("%.2f Hours", this.toHours()
													.doubleValue());

		} else if (this.microseconds.compareTo(TimeConverter.microsecondToMinute) >= 0) {
			return String.format("%.2f Minutes", this.toMinutes()
														.doubleValue());

		} else if (this.microseconds.compareTo(TimeConverter.microsecondToSecond) >= 0) {
			return String.format("%.2f Seconds", this.toSeconds()
														.doubleValue());

		} else if (this.microseconds.compareTo(TimeConverter.microsecondToMillisecond) >= 0) {
			return String.format("%.2f Milliseconds", this.toMicroseconds()
															.doubleValue());

		} else {
			return String.format("%l Microseconds", this.toYears()
														.doubleValue());
		}
	}
}
