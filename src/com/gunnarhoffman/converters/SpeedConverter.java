package com.gunnarhoffman.converters;

import java.math.BigDecimal;
import java.security.InvalidParameterException;

/**
 * 
 * @author Gunnar Hoffman
 * 
 */
public abstract class SpeedConverter {

	/**
	 * 
	 * @author Gunnar Hoffman
	 * 
	 */
	public static enum TimeIncrement {
		Second, Minute, Hour, Day, Week, Year
	}

	/**
	 * 
	 * @author Gunnar Hoffman
	 * 
	 */
	public class MetricSpeedConverter extends SpeedConverter {

		@Override
		public BigDecimal toMetersPer(TimeIncrement increment) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal toFeetPer(TimeIncrement increment) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal toKilometersPer(TimeIncrement increment) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal toMilesPer(TimeIncrement increment) {
			// TODO Auto-generated method stub
			return null;
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

	}

	/**
	 * 
	 * @author Gunnar Hoffman
	 * 
	 */
	public class ImperialSpeedConverter extends SpeedConverter {

		@Override
		public BigDecimal toMetersPer(TimeIncrement increment) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal toFeetPer(TimeIncrement increment) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal toKilometersPer(TimeIncrement increment) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal toMilesPer(TimeIncrement increment) {
			// TODO Auto-generated method stub
			return null;
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

	}

	private BigDecimal unit;
	private TimeIncrement increment;

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

	public final TimeIncrement getTimeIncrement() {
		return this.increment;
	}

	public static SpeedConverter fromMetersPer(double meters,
			TimeIncrement increment) {
		return null;
	}

	public abstract BigDecimal toMetersPer(TimeIncrement increment);

	public abstract BigDecimal toKilometersPer(TimeIncrement increment);

	public abstract BigDecimal toFeetPer(TimeIncrement increment);

	public abstract BigDecimal toMilesPer(TimeIncrement increment);

	public abstract BigDecimal toAstronomicalUnitsPer(TimeIncrement increment);

	public abstract BigDecimal toLightYearsPer(TimeIncrement increment);

	public abstract BigDecimal toParsecsPer(TimeIncrement increment);
}
