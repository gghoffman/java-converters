package com.gunnarhoffman.converters;

import java.math.BigDecimal;
import java.security.InvalidParameterException;

import com.gunnarhoffman.converters.concrete.speed.ImperialSpeedConverter;
import com.gunnarhoffman.converters.concrete.speed.MetricSpeedConverter;

/**
 * This class allows for the conversion of units of speed (distance over time).
 * Units may be feet, meters, or astronomical units.
 * 
 * @author Gunnar Hoffman
 * 
 */
public abstract class SpeedConverter {

	public static int DEFAULT_SCALE = 100;
	public static int DEFAULT_ROUNDING_MODE = BigDecimal.ROUND_HALF_UP;

	public static final BigDecimal METERS_IN_A_KILOMETER = new BigDecimal(
			"1000");
	public static final BigDecimal FEET_IN_A_MILE = new BigDecimal("5280");
	public static final BigDecimal FEET_IN_A_METER = new BigDecimal("3.28084");

	public static final BigDecimal METERS_IN_AN_ASTRONOMICAL_UNIT = new BigDecimal(
			"149597870700");
	public static final BigDecimal METERS_IN_A_LIGHT_YEAR = new BigDecimal(
			"9460528400000000");
	public static final BigDecimal METERS_IN_A_PARSEC = new BigDecimal(
			"30856775800000000");

	public static final BigDecimal FEET_IN_AN_ASTRONOMICAL_UNIT = new BigDecimal(
			"490806662000");
	public static final BigDecimal FEET_IN_A_LIGHT_YEAR = new BigDecimal(
			"31038479000000000");
	public static final BigDecimal FEET_IN_A_PARSEC = new BigDecimal(
			"101236141000000000");

	/**
	 * This enumeration contains all the time increments we can convert between.
	 * 
	 * @author Gunnar Hoffman
	 * 
	 */
	public static enum TimeIncrement {
		Second(1), Minute(60), Hour(3600), Day(86400), Week(604800), Year(
				31560000);

		private BigDecimal seconds;

		TimeIncrement(int seconds) {
			this.seconds = new BigDecimal(Integer.toString(seconds));
		}

		public BigDecimal getSeconds() {
			return this.seconds;
		}
	}

	public SpeedConverter(BigDecimal unitsPerSecond) {
		this.setUnit(unitsPerSecond);
	}

	private BigDecimal unit;

	public final BigDecimal getUnit() {
		return this.unit;
	}

	/**
	 * <p>
	 * Sets the raw unit value in the underlying data source for this class.
	 * </p>
	 * 
	 * <p>
	 * This method is final to protect the constructor from undefined behavior
	 * should this class be extended.
	 * </p>
	 * 
	 * <p>
	 * In the event a negative number is passed into this function a runtime
	 * exception of the type InvalidParameterException will be thrown. All
	 * static methods on this object indirectly call this method and therefor
	 * can also throw this exception.
	 * </p>
	 * 
	 * @param number
	 *            The number of units to operate over.
	 * @return An instance of this class containing the unit number.
	 */
	public final SpeedConverter setUnit(BigDecimal unit) {
		if (unit.signum() == -1) {
			throw new InvalidParameterException(
					"negative speed makes no sense!");
		}
		this.unit = unit;
		return this;
	}

	// Metric static initializers

	public static SpeedConverter fromMetersPer(double meters,
			TimeIncrement increment) {
		return SpeedConverter.fromMetersPer(
				new BigDecimal(Double.toString(meters)), increment);
	}

	public static SpeedConverter fromMetersPer(BigDecimal meters,
			TimeIncrement increment) {

		return new MetricSpeedConverter(meters.divide(increment.getSeconds(),
				DEFAULT_SCALE, DEFAULT_ROUNDING_MODE));
	}

	public static SpeedConverter fromKilometersPer(double kilometers,
			TimeIncrement increment) {
		return SpeedConverter.fromKilometersPer(
				new BigDecimal(Double.toString(kilometers)), increment);
	}

	public static SpeedConverter fromKilometersPer(BigDecimal kilometers,
			TimeIncrement increment) {

		return new MetricSpeedConverter(kilometers.multiply(
				SpeedConverter.METERS_IN_A_KILOMETER).divide(
				increment.getSeconds(), DEFAULT_SCALE, DEFAULT_ROUNDING_MODE));
	}

	// Imperial static initializers

	public static SpeedConverter fromFeetPer(double feet,
			TimeIncrement increment) {
		return SpeedConverter.fromFeetPer(new BigDecimal(feet), increment);
	}

	public static SpeedConverter fromFeetPer(BigDecimal feet,
			TimeIncrement increment) {

		return new ImperialSpeedConverter(feet.divide(increment.getSeconds(),
				DEFAULT_SCALE, DEFAULT_ROUNDING_MODE));
	}

	public static SpeedConverter fromMilesPer(double yards,
			TimeIncrement increment) {
		return SpeedConverter.fromMilesPer(
				new BigDecimal(Double.toString(yards)), increment);
	}

	public static SpeedConverter fromMilesPer(BigDecimal yards,
			TimeIncrement increment) {

		return new ImperialSpeedConverter(yards.multiply(
				SpeedConverter.FEET_IN_A_MILE).divide(increment.getSeconds(),
				DEFAULT_SCALE, DEFAULT_ROUNDING_MODE));
	}

	// Astronomical static initializers

	public static SpeedConverter fromAstronomicalUnitsPer(
			double astronomicalUnits, TimeIncrement increment) {

		return SpeedConverter.fromAstronomicalUnitsPer(
				new BigDecimal(Double.toString(astronomicalUnits)), increment);
	}

	public static SpeedConverter fromAstronomicalUnitsPer(
			BigDecimal astronomicalUnits, TimeIncrement increment) {

		return new MetricSpeedConverter(astronomicalUnits.multiply(
				SpeedConverter.METERS_IN_AN_ASTRONOMICAL_UNIT).divide(
				increment.getSeconds(), DEFAULT_SCALE, DEFAULT_ROUNDING_MODE));
	}

	public static SpeedConverter fromLightYearsPer(double lightYears,
			TimeIncrement increment) {

		return SpeedConverter.fromLightYearsPer(
				new BigDecimal(Double.toString(lightYears)), increment);
	}

	public static SpeedConverter fromLightYearsPer(BigDecimal lightYears,
			TimeIncrement increment) {

		return new MetricSpeedConverter(lightYears.multiply(
				SpeedConverter.METERS_IN_A_LIGHT_YEAR).divide(
				increment.getSeconds(), DEFAULT_SCALE, DEFAULT_ROUNDING_MODE));
	}

	public static SpeedConverter fromParsecsPer(BigDecimal parsecs,
			TimeIncrement increment) {

		return new MetricSpeedConverter(parsecs.multiply(
				SpeedConverter.METERS_IN_A_PARSEC).divide(
				increment.getSeconds(), DEFAULT_SCALE, DEFAULT_ROUNDING_MODE));
	}

	public abstract BigDecimal toMetersPer(TimeIncrement increment);

	public abstract BigDecimal toKilometersPer(TimeIncrement increment);

	public abstract BigDecimal toFeetPer(TimeIncrement increment);

	public abstract BigDecimal toMilesPer(TimeIncrement increment);

	public abstract BigDecimal toAstronomicalUnitsPer(TimeIncrement increment);

	public abstract BigDecimal toLightYearsPer(TimeIncrement increment);

	public abstract BigDecimal toParsecsPer(TimeIncrement increment);
}
