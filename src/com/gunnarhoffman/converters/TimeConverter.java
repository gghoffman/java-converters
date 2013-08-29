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

	public static final BigDecimal MICROSECONDS_IN_A_MILLISECOND = new BigDecimal(
			"1000");
	public static final BigDecimal MICROSECONDS_IN_A_SECOND = new BigDecimal(
			"1000000");
	public static final BigDecimal MICROSECONDS_IN_A_MINUTE = new BigDecimal(
			"60000000");
	public static final BigDecimal MICROSECONDS_IN_AN_HOUR = new BigDecimal(
			"3600000000");
	public static final BigDecimal MICROSECONDS_IN_A_DAY = new BigDecimal(
			"86400000000");
	public static final BigDecimal MICROSECONDS_IN_A_WEEK = new BigDecimal(
			"604800000000");

	/**
	 * Calculated using 365.242 days per year.
	 */
	public static final BigDecimal MICROSECONDS_IN_A_YEAR = new BigDecimal(
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
		return TimeConverter.fromMicroseconds(new BigDecimal(Long
				.toString(microseconds)));
	}

	public static TimeConverter fromMicroseconds(BigDecimal microseconds) {
		return new TimeConverter(microseconds);
	}

	public static TimeConverter fromMilliseconds(long milliseconds) {
		return TimeConverter.fromMilliseconds(new BigDecimal(Long
				.toString(milliseconds)));
	}

	public static TimeConverter fromMilliseconds(BigDecimal milliseconds) {

		BigDecimal calculator = new BigDecimal(milliseconds.toString());
		calculator = calculator
				.multiply(TimeConverter.MICROSECONDS_IN_A_MILLISECOND);
		return new TimeConverter(calculator);
	}

	public static TimeConverter fromSeconds(double seconds) {
		return TimeConverter.fromSeconds(new BigDecimal(Double
				.toString(seconds)));
	}

	public static TimeConverter fromSeconds(BigDecimal seconds) {

		BigDecimal calculator = new BigDecimal(seconds.toString());
		calculator = calculator
				.multiply(TimeConverter.MICROSECONDS_IN_A_SECOND);
		return new TimeConverter(calculator);
	}

	public static TimeConverter fromMinutes(double minutes) {
		return TimeConverter.fromMinutes(new BigDecimal(Double
				.toString(minutes)));
	}

	public static TimeConverter fromMinutes(BigDecimal minutes) {

		BigDecimal calculator = new BigDecimal(minutes.toString());
		calculator = calculator
				.multiply(TimeConverter.MICROSECONDS_IN_A_MINUTE);
		return new TimeConverter(calculator);
	}

	public static TimeConverter fromHours(double hours) {
		return TimeConverter.fromHours(new BigDecimal(Double.toString(hours)));
	}

	public static TimeConverter fromHours(BigDecimal hours) {

		BigDecimal calculator = new BigDecimal(hours.toString());
		calculator = calculator.multiply(TimeConverter.MICROSECONDS_IN_AN_HOUR);
		return new TimeConverter(calculator);
	}

	public static TimeConverter fromDays(double days) {
		return TimeConverter.fromDays(new BigDecimal(Double.toString(days)));
	}

	public static TimeConverter fromDays(BigDecimal days) {

		BigDecimal calculator = new BigDecimal(days.toString());
		calculator = calculator.multiply(TimeConverter.MICROSECONDS_IN_A_DAY);
		return new TimeConverter(calculator);
	}

	public static TimeConverter fromWeeks(double weeks) {
		return TimeConverter.fromWeeks(new BigDecimal(Double.toString(weeks)));
	}

	public static TimeConverter fromWeeks(BigDecimal weeks) {

		BigDecimal calculator = new BigDecimal(weeks.toString());
		calculator = calculator.multiply(TimeConverter.MICROSECONDS_IN_A_WEEK);
		return new TimeConverter(calculator);
	}

	public static TimeConverter fromYears(double years) {
		return TimeConverter.fromYears(new BigDecimal(Double.toString(years)));
	}

	public static TimeConverter fromYears(BigDecimal years) {

		BigDecimal calculator = new BigDecimal(years.toString());
		calculator = calculator.multiply(TimeConverter.MICROSECONDS_IN_A_YEAR);
		return new TimeConverter(calculator);
	}

	// Output

	public BigInteger toMicroseconds() {
		return this.microseconds.toBigInteger();
	}

	public BigDecimal toMilliseconds() {
		return this.microseconds.divide(
				TimeConverter.MICROSECONDS_IN_A_MILLISECOND, 100,
				BigDecimal.ROUND_HALF_UP);
	}

	public BigDecimal toSeconds() {
		return this.microseconds.divide(TimeConverter.MICROSECONDS_IN_A_SECOND,
				100, BigDecimal.ROUND_HALF_UP);
	}

	public BigDecimal toMinutes() {
		return this.microseconds.divide(TimeConverter.MICROSECONDS_IN_A_MINUTE,
				100, BigDecimal.ROUND_HALF_UP);
	}

	public BigDecimal toHours() {
		return this.microseconds.divide(TimeConverter.MICROSECONDS_IN_AN_HOUR,
				100, BigDecimal.ROUND_HALF_UP);
	}

	public BigDecimal toDays() {
		return this.microseconds.divide(TimeConverter.MICROSECONDS_IN_A_DAY,
				100, BigDecimal.ROUND_HALF_UP);
	}

	public BigDecimal toWeeks() {
		return this.microseconds.divide(TimeConverter.MICROSECONDS_IN_A_WEEK,
				100, BigDecimal.ROUND_HALF_UP);
	}

	public BigDecimal toYears() {
		return this.microseconds.divide(TimeConverter.MICROSECONDS_IN_A_YEAR,
				100, BigDecimal.ROUND_HALF_UP);
	}

	@Override
	public String toString() {

		if (this.microseconds.compareTo(TimeConverter.MICROSECONDS_IN_A_YEAR) >= 0) {
			return String.format("%.2f Years", this.toYears().doubleValue());

		} else if (this.microseconds
				.compareTo(TimeConverter.MICROSECONDS_IN_A_WEEK) >= 0) {
			return String.format("%.2f Weeks", this.toWeeks().doubleValue());

		} else if (this.microseconds
				.compareTo(TimeConverter.MICROSECONDS_IN_A_DAY) >= 0) {
			return String.format("%.2f Days", this.toDays().doubleValue());

		} else if (this.microseconds
				.compareTo(TimeConverter.MICROSECONDS_IN_AN_HOUR) >= 0) {
			return String.format("%.2f Hours", this.toHours().doubleValue());

		} else if (this.microseconds
				.compareTo(TimeConverter.MICROSECONDS_IN_A_MINUTE) >= 0) {
			return String
					.format("%.2f Minutes", this.toMinutes().doubleValue());

		} else if (this.microseconds
				.compareTo(TimeConverter.MICROSECONDS_IN_A_SECOND) >= 0) {
			return String
					.format("%.2f Seconds", this.toSeconds().doubleValue());

		} else if (this.microseconds
				.compareTo(TimeConverter.MICROSECONDS_IN_A_MILLISECOND) >= 0) {
			return String.format("%.2f Milliseconds", this.toMilliseconds()
					.doubleValue());

		} else {
			return String.format("%f Microseconds", this.toMicroseconds()
					.doubleValue());
		}
	}
}
