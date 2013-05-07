package com.gunnarhoffman.converters.concrete.speed;

import java.math.BigDecimal;

import com.gunnarhoffman.converters.SpeedConverter;

/**
 * Concrete implementation of the SpeedConverter class. Speed for this
 * implementation is stored in fractional Feet per Second.
 * 
 * @author Gunnar Hoffman
 * 
 */
public class ImperialSpeedConverter extends SpeedConverter {

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
				.divide(SpeedConverter.METERS_IN_A_KILOMETER, DEFAULT_SCALE,
						DEFAULT_ROUNDING_MODE)
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
		return this.getUnit()
				.divide(SpeedConverter.FEET_IN_AN_ASTRONOMICAL_UNIT,
						DEFAULT_SCALE, DEFAULT_ROUNDING_MODE)
				.multiply(increment.getSeconds());
	}

	@Override
	public BigDecimal toLightYearsPer(TimeIncrement increment) {
		return this.getUnit()
				.divide(SpeedConverter.FEET_IN_A_LIGHT_YEAR, DEFAULT_SCALE,
						DEFAULT_ROUNDING_MODE)
				.multiply(increment.getSeconds());
	}

	@Override
	public BigDecimal toParsecsPer(TimeIncrement increment) {
		return this.getUnit()
				.divide(SpeedConverter.FEET_IN_A_PARSEC, DEFAULT_SCALE,
						DEFAULT_ROUNDING_MODE)
				.multiply(increment.getSeconds());
	}

	@Override
	public String toString() {
		return String.format("%f f/s", this.getUnit()
				.doubleValue());
	}

}