package com.gunnarhoffman.converters.concrete.distance;

import java.math.BigDecimal;

import com.gunnarhoffman.converters.DistanceConverter;

/**
 * A concrete implementation of the DistanceConverter class that uses a base
 * unit of Inches.
 * 
 * @author Gunnar Hoffman
 * 
 */
public class ImperialDistanceConverter extends DistanceConverter {

	public ImperialDistanceConverter(BigDecimal inches) {
		this.setUnit(inches);
	}

	// Metric output

	@Override
	public BigDecimal toMicrometers() {
		return this.getUnit()
				.multiply(DistanceConverter.MICROMETERS_IN_AN_INCH);
	}

	@Override
	public BigDecimal toMilimeters() {
		return this.getUnit()
				.multiply(DistanceConverter.MILLIMETERS_IN_AN_INCH);
	}

	@Override
	public BigDecimal toCentimeters() {
		return this.getUnit()
				.multiply(DistanceConverter.CENTAMETERS_IN_AN_INCH);
	}

	@Override
	public BigDecimal toMeters() {
		return this.getUnit()
				.divide(DistanceConverter.INCHES_IN_A_METER, DEFAULT_SCALE,
						DEFAULT_ROUNDING_MODE);
	}

	@Override
	public BigDecimal toKilometers() {
		return this.getUnit()
				.divide(DistanceConverter.INCHES_IN_A_KILOMETER, DEFAULT_SCALE,
						DEFAULT_ROUNDING_MODE);
	}

	// Imperial output

	@Override
	public BigDecimal toInches() {
		return this.getUnit();
	}

	@Override
	public BigDecimal toFeet() {
		return this.getUnit()
				.divide(DistanceConverter.INCHES_IN_A_FOOT, DEFAULT_SCALE,
						DEFAULT_ROUNDING_MODE);
	}

	@Override
	public BigDecimal toYards() {
		return this.getUnit()
				.divide(DistanceConverter.INCHES_IN_A_YARD, DEFAULT_SCALE,
						DEFAULT_ROUNDING_MODE);
	}

	@Override
	public BigDecimal toMiles() {
		return this.getUnit()
				.divide(DistanceConverter.INCHES_IN_A_MILE, DEFAULT_SCALE,
						DEFAULT_ROUNDING_MODE);
	}

	@Override
	public BigDecimal toAstronomicalUnits() {
		return this.getUnit()
				.divide(DistanceConverter.INCHES_IN_AN_ASTRONOMICAL_UNIT,
						DEFAULT_SCALE, DEFAULT_ROUNDING_MODE);
	}

	@Override
	public BigDecimal toLightYears() {
		return this.getUnit()
				.divide(DistanceConverter.INCHES_IN_A_LIGHT_YEAR, DEFAULT_SCALE,
						DEFAULT_ROUNDING_MODE);
	}

	@Override
	public BigDecimal toParsecs() {
		return this.getUnit()
				.divide(DistanceConverter.INCHES_IN_A_PARSEC, DEFAULT_SCALE,
						DEFAULT_ROUNDING_MODE);
	}

	// String output

	/*
	 * This method will output as imperial units of measure unless it is large
	 * enough for astronomical.
	 */
	@Override
	public String toString() {

		if (this.getUnit()
				.compareTo(DistanceConverter.INCHES_IN_A_PARSEC) >= 0) {
			return String.format("%.2f Parsecs", this.toParsecs()
					.doubleValue());

		} else if (this.getUnit()
				.compareTo(DistanceConverter.INCHES_IN_A_LIGHT_YEAR) >= 0) {
			return String.format("%.2f Light Years", this.toLightYears()
					.doubleValue());

		} else if (this.getUnit()
				.compareTo(DistanceConverter.INCHES_IN_AN_ASTRONOMICAL_UNIT) >= 0) {
			return String.format("%.2f Astronumical Units",
					this.toAstronomicalUnits()
							.doubleValue());

		} else if (this.getUnit()
				.compareTo(DistanceConverter.INCHES_IN_A_MILE) >= 0) {
			return String.format("%.2f Miles", this.toMiles()
					.doubleValue());

		} else if (this.getUnit()
				.compareTo(DistanceConverter.INCHES_IN_A_YARD) >= 0) {
			return String.format("%.2f Yards", this.toYards()
					.doubleValue());

		} else if (this.getUnit()
				.compareTo(DistanceConverter.INCHES_IN_A_FOOT) >= 0) {
			return String.format("%.2f Feet", this.toFeet()
					.doubleValue());

		} else {
			return String.format("%.2f Inches", this.toInches()
					.doubleValue());
		}
	}

}
