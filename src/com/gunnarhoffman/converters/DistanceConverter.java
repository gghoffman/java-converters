package com.gunnarhoffman.converters;

import java.math.BigDecimal;
import java.security.InvalidParameterException;

import com.gunnarhoffman.converters.concrete.distance.ImperialDistanceConverter;
import com.gunnarhoffman.converters.concrete.distance.MetricDistanceConverter;

/**
 * This class allows for the conversion between three length/distance type
 * systems. Metric, Imperial, and Astronomical. Each system ranges in size
 * respectivly from Mirometers to Kilometers, Inches to Miles, and Astronomical
 * Units to Parsecs.
 * 
 * The conversion between these systems is only lossy if division causes a never
 * terminating decimal, in that case it will halt at the hundreth deciaml place.
 * 
 * @author Gunnar Hoffman
 * 
 */
public abstract class DistanceConverter {

	// Constants

	public static final int DEFAULT_SCALE = 100;
	public static final int DEFAULT_ROUNDING_MODE = BigDecimal.ROUND_HALF_UP;

	public static final BigDecimal MILLIMETERS_IN_AN_INCH = new BigDecimal(
			"25.4");
	public static final BigDecimal CENTAMETERS_IN_AN_INCH = new BigDecimal(
			"2.54");

	public static final BigDecimal MICROMETERS_IN_AN_INCH = new BigDecimal(
			"25400");
	public static final BigDecimal MICROMETERS_IN_A_FOOT = new BigDecimal(
			"304800");
	public static final BigDecimal MICROMETERS_IN_A_YARD = new BigDecimal(
			"914400");
	public static final BigDecimal MICROMETERS_IN_A_MILE = new BigDecimal(
			"1609344000");

	public static final BigDecimal MICROMETERS_IN_A_MILAMETER = new BigDecimal(
			"1000");
	public static final BigDecimal MICROMETERS_IN_A_CENTIMETER = new BigDecimal(
			"10000");
	public static final BigDecimal MICROMETERS_IN_A_METER = new BigDecimal(
			"1000000");
	public static final BigDecimal MICROMETERS_IN_A_KILOMETER = new BigDecimal(
			"1000000000");

	public static final BigDecimal MICROMETERS_IN_AN_ASTRONOMICAL_UNIT = new BigDecimal(
			"149597871000000000");
	public static final BigDecimal MICROMETERS_IN_A_LIGHT_YEAR = new BigDecimal(
			"9460528400000000000000");
	public static final BigDecimal MICROMETERS_IN_A_PARSEC = new BigDecimal(
			"30856775800000000000000");

	public static final BigDecimal INCHES_IN_A_FOOT = new BigDecimal("12");
	public static final BigDecimal INCHES_IN_A_YARD = new BigDecimal("36");
	public static final BigDecimal INCHES_IN_A_MILE = new BigDecimal("63360");
	public static final BigDecimal INCHES_IN_A_METER = new BigDecimal("39.3701");
	public static final BigDecimal INCHES_IN_A_KILOMETER = new BigDecimal(
			"39370.1");
	public static final BigDecimal INCHES_IN_AN_ASTRONOMICAL_UNIT = new BigDecimal(
			"5889679950000");
	public static final BigDecimal INCHES_IN_A_LIGHT_YEAR = new BigDecimal(
			"372461748000000000");
	public static final BigDecimal INCHES_IN_A_PARSEC = new BigDecimal(
			"1214833690000000000");

	// Instance fields

	private BigDecimal unit;

	// Setters

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
	public final DistanceConverter setUnit(BigDecimal unit) {
		if (unit.signum() == -1) {
			throw new InvalidParameterException(
					"negative distance makes no sense!");
		}
		this.unit = unit;
		return this;
	}

	// Constructors

	public final BigDecimal getUnit() {
		return this.unit;
	}

	// Metric static initializers

	public static DistanceConverter fromMicrometers(long micrometers) {
		return DistanceConverter.fromMicrometers(new BigDecimal(
				Long.toString(micrometers)));
	}

	public static DistanceConverter fromMicrometers(BigDecimal micrometers) {
		return new MetricDistanceConverter(micrometers);
	}

	public static DistanceConverter fromMillimeters(double millimeters) {
		return DistanceConverter.fromMillimeters(new BigDecimal(
				Double.toString(millimeters)));
	}

	public static DistanceConverter fromMillimeters(BigDecimal millimeters) {
		return new MetricDistanceConverter(
				millimeters.multiply(DistanceConverter.MICROMETERS_IN_A_MILAMETER));
	}

	public static DistanceConverter fromCentimeters(double centimeters) {
		return DistanceConverter.fromCentimeters(new BigDecimal(
				Double.toString(centimeters)));
	}

	public static DistanceConverter fromCentimeters(BigDecimal centimeters) {
		return new MetricDistanceConverter(
				centimeters.multiply(DistanceConverter.MICROMETERS_IN_A_CENTIMETER));
	}

	public static DistanceConverter fromMeters(double meters) {
		return DistanceConverter.fromMeters(new BigDecimal(
				Double.toString(meters)));
	}

	public static DistanceConverter fromMeters(BigDecimal meters) {
		return new MetricDistanceConverter(
				meters.multiply(DistanceConverter.MICROMETERS_IN_A_METER));
	}

	public static DistanceConverter fromKilometers(double kilometers) {
		return DistanceConverter.fromKilometers(new BigDecimal(
				Double.toString(kilometers)));
	}

	public static DistanceConverter fromKilometers(BigDecimal kilometers) {
		return new MetricDistanceConverter(
				kilometers.multiply(DistanceConverter.MICROMETERS_IN_A_KILOMETER));
	}

	// Imperial static initializers

	public static DistanceConverter fromInches(double inches) {
		return DistanceConverter.fromInches(new BigDecimal(
				Double.toString(inches)));
	}

	public static DistanceConverter fromInches(BigDecimal inches) {
		return new ImperialDistanceConverter(inches);
	}

	public static DistanceConverter fromFeet(double feet) {
		return DistanceConverter.fromFeet(new BigDecimal(Double.toString(feet)));
	}

	public static DistanceConverter fromFeet(BigDecimal feet) {
		return new ImperialDistanceConverter(
				feet.multiply(DistanceConverter.INCHES_IN_A_FOOT));
	}

	public static DistanceConverter fromYards(double yards) {
		return DistanceConverter.fromYards(new BigDecimal(
				Double.toString(yards)));
	}

	public static DistanceConverter fromYards(BigDecimal yards) {
		return new ImperialDistanceConverter(
				yards.multiply(DistanceConverter.INCHES_IN_A_YARD));
	}

	public static DistanceConverter fromMiles(double miles) {
		return DistanceConverter.fromMiles(new BigDecimal(
				Double.toString(miles)));
	}

	public static DistanceConverter fromMiles(BigDecimal miles) {
		return new ImperialDistanceConverter(
				miles.multiply(DistanceConverter.INCHES_IN_A_MILE));
	}

	// Astronomical static initializers

	public static DistanceConverter fromAstronomicalUnits(
			double astronomicalUnits) {
		return DistanceConverter.fromAstronomicalUnits(new BigDecimal(
				Double.toString(astronomicalUnits)));
	}

	public static DistanceConverter fromAstronomicalUnits(
			BigDecimal astronomicalUnits) {
		return new MetricDistanceConverter(
				DistanceConverter.MICROMETERS_IN_AN_ASTRONOMICAL_UNIT.multiply(astronomicalUnits));
	}

	public static DistanceConverter fromLightYears(double lightYears) {
		return DistanceConverter.fromLightYears(new BigDecimal(
				Double.toString(lightYears)));
	}

	public static DistanceConverter fromLightYears(BigDecimal lightYears) {
		return new MetricDistanceConverter(
				DistanceConverter.MICROMETERS_IN_A_LIGHT_YEAR.multiply(lightYears));
	}

	public static DistanceConverter fromParsecs(double parsecs) {
		return DistanceConverter.fromParsecs(new BigDecimal(
				Double.toString(parsecs)));
	}

	public static DistanceConverter fromParsecs(BigDecimal parsecs) {
		return new MetricDistanceConverter(
				DistanceConverter.MICROMETERS_IN_A_PARSEC.multiply(parsecs));
	}

	// Metric output

	public abstract BigDecimal toMicrometers();

	public abstract BigDecimal toMilimeters();

	public abstract BigDecimal toCentimeters();

	public abstract BigDecimal toMeters();

	public abstract BigDecimal toKilometers();

	// Imperal output

	public abstract BigDecimal toInches();

	public abstract BigDecimal toFeet();

	public abstract BigDecimal toYards();

	public abstract BigDecimal toMiles();

	// Astronomy output

	public abstract BigDecimal toAstronomicalUnits();

	public abstract BigDecimal toLightYears();

	public abstract BigDecimal toParsecs();
}
