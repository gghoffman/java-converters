package com.gunnarhoffman.converters;

import java.math.BigDecimal;
import java.security.InvalidParameterException;

import com.gunnarhoffman.converters.concrete.distance.ImperialDistanceConverter;
import com.gunnarhoffman.converters.concrete.distance.MetricDistanceConverter;
import com.sun.tools.doclets.formats.html.resources.standard;

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
	 * 
	 * @param unit
	 * @return
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

	// TODO

	// Imperial static initializers

	public static DistanceConverter fromInches(double inches) {
		return DistanceConverter.fromInches(new BigDecimal(
				Double.toString(inches)));
	}

	public static DistanceConverter fromInches(BigDecimal inches) {
		return new ImperialDistanceConverter(inches);
	}

	// TODO

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
