package com.gunnarhoffman.converters.concrete.speed;

import java.math.BigDecimal;

import com.gunnarhoffman.converters.SpeedConverter;

/**
 * Concrete implementation of the SpeedConverter class. Speed for this
 * implementation is stored in fractional Meters per Second.
 * 
 * @author Gunnar Hoffman
 * 
 */
public class MetricSpeedConverter extends SpeedConverter {

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
				.divide(SpeedConverter.METERS_IN_A_KILOMETER, DEFAULT_SCALE,
						DEFAULT_ROUNDING_MODE)
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
		return this.getUnit()
				.divide(SpeedConverter.METERS_IN_AN_ASTRONOMICAL_UNIT,
						DEFAULT_SCALE, DEFAULT_ROUNDING_MODE)
				.multiply(increment.getSeconds());
	}

	@Override
	public BigDecimal toLightYearsPer(TimeIncrement increment) {
		return this.getUnit()
				.divide(SpeedConverter.METERS_IN_A_LIGHT_YEAR, DEFAULT_SCALE,
						DEFAULT_ROUNDING_MODE)
				.multiply(increment.getSeconds());
	}

	@Override
	public BigDecimal toParsecsPer(TimeIncrement increment) {
		return this.getUnit()
				.divide(SpeedConverter.METERS_IN_A_PARSEC, DEFAULT_SCALE,
						DEFAULT_ROUNDING_MODE)
				.multiply(increment.getSeconds());
	}

	@Override
	public String toString() {
		return String.format("%f m/s", this.getUnit()
				.doubleValue());
	}

}