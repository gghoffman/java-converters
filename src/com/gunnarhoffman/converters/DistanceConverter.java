package com.gunnarhoffman.converters;

import java.math.BigDecimal;
import java.security.InvalidParameterException;

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

	private static final int DEFAULT_SCALE = 100;
	private static final int DEFAULT_ROUNDING_MODE = BigDecimal.ROUND_HALF_UP;

	private static final BigDecimal micrometersInAnInch = new BigDecimal(
			"25400");
	private static final BigDecimal micrometersInAMilimeter = new BigDecimal(
			"1000");
	private static final BigDecimal micrometersInACentameter = new BigDecimal(
			"10000");
	private static final BigDecimal micrometersInAMeter = new BigDecimal(
			"1000000");
	private static final BigDecimal micrometersInKilometer = new BigDecimal(
			"1000000000");

	// Instance fields

	private BigDecimal unit;

	// Concrete DistanceConverter implementations

	/**
	 * A concrete implementation of the DistanceConverter class that uses a base
	 * unit of Micrometers.
	 * 
	 * @author Gunnar Hoffman
	 * 
	 */
	public static class MetricDistanceConverter extends DistanceConverter {

		private MetricDistanceConverter(BigDecimal micrometers) {
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
					.divide(DistanceConverter.micrometersInAMilimeter,
							DEFAULT_SCALE, DEFAULT_ROUNDING_MODE);
		}

		@Override
		public BigDecimal toCentimeters() {
			return this.getUnit()
					.divide(DistanceConverter.micrometersInACentameter,
							DEFAULT_SCALE, DEFAULT_ROUNDING_MODE);
		}

		@Override
		public BigDecimal toMeters() {
			return this.getUnit()
					.divide(DistanceConverter.micrometersInAMeter,
							DEFAULT_SCALE, DEFAULT_ROUNDING_MODE);
		}

		@Override
		public BigDecimal toKilometers() {
			return this.getUnit()
					.divide(DistanceConverter.micrometersInKilometer,
							DEFAULT_SCALE, DEFAULT_ROUNDING_MODE);
		}

		// Imperial output

		@Override
		public BigDecimal toInches() {
			return this.getUnit()
					.divide(DistanceConverter.micrometersInAnInch,
							DEFAULT_SCALE, DEFAULT_ROUNDING_MODE);
		}

		@Override
		public BigDecimal toFeet() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal toYards() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal toMiles() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal toAstronomicalUnits() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal toLightYears() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal toParsecs() {
			// TODO Auto-generated method stub
			return null;
		}

		/*
		 * This method will output as metric units of measure unless it is large
		 * enough for astronomical.
		 */
		@Override
		public String toString() {

			return null;
		}

	}

	/**
	 * A concrete implementation of the DistanceConverter class that uses a base
	 * unit of Inches.
	 * 
	 * @author Gunnar Hoffman
	 * 
	 */
	public static class ImperialDistanceConverter extends DistanceConverter {

		public ImperialDistanceConverter(BigDecimal inches) {
			this.setUnit(inches);
		}

		// Metric output

		@Override
		public BigDecimal toMicrometers() {
			return this.getUnit()
					.multiply(DistanceConverter.micrometersInAnInch);
		}

		@Override
		public BigDecimal toMilimeters() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal toCentimeters() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal toMeters() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal toKilometers() {
			// TODO Auto-generated method stub
			return null;
		}

		// Imperial output

		@Override
		public BigDecimal toInches() {
			return this.getUnit();
		}

		@Override
		public BigDecimal toFeet() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal toYards() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal toMiles() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal toAstronomicalUnits() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal toLightYears() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal toParsecs() {
			// TODO Auto-generated method stub
			return null;
		}

		// String output

		/*
		 * This method will output as imperial units of measure unless it is
		 * large enough for astronomical.
		 */
		@Override
		public String toString() {

			return null;
		}

	}

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

	public static DistanceConverter fromMicroMeters(BigDecimal micrometers) {
		return new MetricDistanceConverter(micrometers);
	}

	// Imperial static initializers

	public static DistanceConverter fromInches(BigDecimal inches) {
		return new ImperialDistanceConverter(inches);
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
