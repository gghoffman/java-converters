package com.gunnarhoffman.converters.concrete.distance;

import java.math.BigDecimal;

import com.gunnarhoffman.converters.DistanceConverter;

/**
 * A concrete implementation of the DistanceConverter class that uses a base
 * unit of Micrometers.
 * 
 * @author Gunnar Hoffman
 * 
 */
public class MetricDistanceConverter extends DistanceConverter {

	public MetricDistanceConverter(BigDecimal micrometers) {
		this.setUnit(micrometers);
	}

	// Metric output

	@Override
	public BigDecimal toMicrometers() {
		return this.getUnit();
	}

	@Override
	public BigDecimal toMilimeters() {
		return this.getUnit()
				.divide(DistanceConverter.MICROMETERS_IN_A_MILAMETER,
						DEFAULT_SCALE, DEFAULT_ROUNDING_MODE);
	}

	@Override
	public BigDecimal toCentimeters() {
		return this.getUnit()
				.divide(DistanceConverter.MICROMETERS_IN_A_CENTIMETER,
						DEFAULT_SCALE, DEFAULT_ROUNDING_MODE);
	}

	@Override
	public BigDecimal toMeters() {
		return this.getUnit()
				.divide(DistanceConverter.MICROMETERS_IN_A_METER,
						DEFAULT_SCALE, DEFAULT_ROUNDING_MODE);
	}

	@Override
	public BigDecimal toKilometers() {
		return this.getUnit()
				.divide(DistanceConverter.MICROMETERS_IN_A_KILOMETER,
						DEFAULT_SCALE, DEFAULT_ROUNDING_MODE);
	}

	// Imperial output

	@Override
	public BigDecimal toInches() {
		return this.getUnit()
				.divide(DistanceConverter.MICROMETERS_IN_AN_INCH,
						DEFAULT_SCALE, DEFAULT_ROUNDING_MODE);
	}

	@Override
	public BigDecimal toFeet() {
		return this.getUnit()
				.divide(DistanceConverter.MICROMETERS_IN_A_FOOT, DEFAULT_SCALE,
						DEFAULT_ROUNDING_MODE);
	}

	@Override
	public BigDecimal toYards() {
		return this.getUnit()
				.divide(DistanceConverter.MICROMETERS_IN_A_YARD, DEFAULT_SCALE,
						DEFAULT_ROUNDING_MODE);
	}

	@Override
	public BigDecimal toMiles() {
		return this.getUnit()
				.divide(DistanceConverter.MICROMETERS_IN_A_MILE, DEFAULT_SCALE,
						DEFAULT_ROUNDING_MODE);
	}

	@Override
	public BigDecimal toAstronomicalUnits() {
		return this.getUnit()
				.divide(DistanceConverter.MICROMETERS_IN_AN_ASTRONOMICAL_UNIT,
						DEFAULT_SCALE, DEFAULT_ROUNDING_MODE);
	}

	@Override
	public BigDecimal toLightYears() {
		return this.getUnit()
				.divide(DistanceConverter.MICROMETERS_IN_A_LIGHT_YEAR,
						DEFAULT_SCALE, DEFAULT_ROUNDING_MODE);
	}

	@Override
	public BigDecimal toParsecs() {
		return this.getUnit()
				.divide(DistanceConverter.MICROMETERS_IN_A_PARSEC,
						DEFAULT_SCALE, DEFAULT_ROUNDING_MODE);
	}

	/*
	 * This method will output as metric units of measure unless it is large
	 * enough for astronomical.
	 */
	@Override
	public String toString() {

		if (this.getUnit()
				.compareTo(DistanceConverter.MICROMETERS_IN_A_PARSEC) >= 0) {
			return String.format("%.2f Parsecs", this.toParsecs()
					.doubleValue());

		} else if (this.getUnit()
				.compareTo(DistanceConverter.MICROMETERS_IN_A_LIGHT_YEAR) >= 0) {
			return String.format("%.2f Light Years", this.toLightYears()
					.doubleValue());

		} else if (this.getUnit()
				.compareTo(
						DistanceConverter.MICROMETERS_IN_AN_ASTRONOMICAL_UNIT) >= 0) {
			return String.format("%.2f Astronumical Units",
					this.toAstronomicalUnits()
							.doubleValue());

		} else if (this.getUnit()
				.compareTo(DistanceConverter.MICROMETERS_IN_A_KILOMETER) >= 0) {
			return String.format("%.2f Kilometers", this.toKilometers()
					.doubleValue());

		} else if (this.getUnit()
				.compareTo(DistanceConverter.MICROMETERS_IN_A_METER) >= 0) {
			return String.format("%.2f Meters", this.toMeters()
					.doubleValue());

		} else if (this.getUnit()
				.compareTo(DistanceConverter.MICROMETERS_IN_A_CENTIMETER) >= 0) {
			return String.format("%.2f Centimeters", this.toCentimeters()
					.doubleValue());

		} else if (this.getUnit()
				.compareTo(DistanceConverter.MICROMETERS_IN_A_MILAMETER) >= 0) {
			return String.format("%.2f Milimeters", this.toMilimeters()
					.doubleValue());

		} else {
			return String.format("%.2f Micrometers", this.toMicrometers()
					.doubleValue());
		}
	}

}
