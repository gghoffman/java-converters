package com.gunnarhoffman.converters;

import java.math.BigDecimal;
import java.security.InvalidParameterException;

/**
 * 
 * @author Gunnar Hoffman
 * 
 */
public abstract class SpeedConverter {

	public static final int DEFAULT_SCALE = 100;
	public static final int DEFAULT_ROUNDING_MODE = BigDecimal.ROUND_HALF_UP;

	public static final BigDecimal METERS_IN_A_KILOMETER = new BigDecimal(
			"1000");
	public static final BigDecimal FEET_IN_A_MILE = new BigDecimal("5280");
	public static final BigDecimal FEET_IN_A_METER = new BigDecimal("3.28084");

	/**
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

	private SpeedConverter(BigDecimal unitsPerSecond) {
		this.setUnit(unitsPerSecond);
	}

	/**
	 * 
	 * @author Gunnar Hoffman
	 * 
	 */
	public static class MetricSpeedConverter extends SpeedConverter {

		public MetricSpeedConverter(BigDecimal metersPerSecond) {
			super(metersPerSecond);
		}

		@Override
		public BigDecimal toMetersPer(TimeIncrement increment) {
			return this.getUnit()
					.multiply(increment.getSeconds());
		}

		@Override
		public BigDecimal toFeetPer(TimeIncrement increment) {
			return this.getUnit()
					.multiply(SpeedConverter.FEET_IN_A_METER)
					.multiply(increment.getSeconds());
		}

		@Override
		public BigDecimal toKilometersPer(TimeIncrement increment) {
			return this.getUnit()
					.divide(SpeedConverter.METERS_IN_A_KILOMETER,
							DEFAULT_SCALE, DEFAULT_ROUNDING_MODE)
					.multiply(increment.getSeconds());
		}

		@Override
		public BigDecimal toMilesPer(TimeIncrement increment) {
			return this.getUnit()
					.multiply(SpeedConverter.FEET_IN_A_METER)
					.divide(SpeedConverter.FEET_IN_A_MILE, DEFAULT_SCALE,
							DEFAULT_ROUNDING_MODE)
					.multiply(increment.getSeconds());
		}

		@Override
		public BigDecimal toAstronomicalUnitsPer(TimeIncrement increment) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal toLightYearsPer(TimeIncrement increment) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal toParsecsPer(TimeIncrement increment) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String toString() {
			return ""; // TODO
		}

	}

	/**
	 * 
	 * @author Gunnar Hoffman
	 * 
	 */
	public static class ImperialSpeedConverter extends SpeedConverter {

		public ImperialSpeedConverter(BigDecimal feetPerSecond) {
			super(feetPerSecond);
		}

		@Override
		public BigDecimal toMetersPer(TimeIncrement increment) {
			return this.getUnit()
					.divide(SpeedConverter.FEET_IN_A_METER, DEFAULT_SCALE,
							DEFAULT_ROUNDING_MODE)
					.multiply(increment.getSeconds());
		}

		@Override
		public BigDecimal toFeetPer(TimeIncrement increment) {
			return this.getUnit()
					.multiply(increment.getSeconds());
		}

		@Override
		public BigDecimal toKilometersPer(TimeIncrement increment) {
			return this.getUnit()
					.divide(SpeedConverter.FEET_IN_A_METER, DEFAULT_SCALE,
							DEFAULT_ROUNDING_MODE)
					.divide(SpeedConverter.METERS_IN_A_KILOMETER,
							DEFAULT_SCALE, DEFAULT_ROUNDING_MODE)
					.multiply(increment.getSeconds());
		}

		@Override
		public BigDecimal toMilesPer(TimeIncrement increment) {
			return this.getUnit()
					.divide(SpeedConverter.FEET_IN_A_MILE, DEFAULT_SCALE,
							DEFAULT_ROUNDING_MODE)
					.multiply(increment.getSeconds());
		}

		@Override
		public BigDecimal toAstronomicalUnitsPer(TimeIncrement increment) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal toLightYearsPer(TimeIncrement increment) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal toParsecsPer(TimeIncrement increment) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String toString() {
			return ""; // TODO
		}

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
				SpeedConverter.METERS_IN_A_KILOMETER)
				.divide(increment.getSeconds(), DEFAULT_SCALE,
						DEFAULT_ROUNDING_MODE));
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
				SpeedConverter.FEET_IN_A_MILE)
				.divide(increment.getSeconds(), DEFAULT_SCALE,
						DEFAULT_ROUNDING_MODE));
	}

	public abstract BigDecimal toMetersPer(TimeIncrement increment);

	public abstract BigDecimal toKilometersPer(TimeIncrement increment);

	public abstract BigDecimal toFeetPer(TimeIncrement increment);

	public abstract BigDecimal toMilesPer(TimeIncrement increment);

	public abstract BigDecimal toAstronomicalUnitsPer(TimeIncrement increment);

	public abstract BigDecimal toLightYearsPer(TimeIncrement increment);

	public abstract BigDecimal toParsecsPer(TimeIncrement increment);
}
