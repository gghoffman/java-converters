package com.gunnarhoffman.converters;

import java.math.BigDecimal;
import java.security.InvalidParameterException;

/**
 * This class allows for basic metric mass unit conversion.
 * 
 * @author Gunnar Hoffman
 * 
 */
public class MassConverter {

	// Constants.

	public static int DEFAULT_SCALE = 100;
	public static int DEFAULT_ROUNDING_MODE = BigDecimal.ROUND_HALF_UP;

	public static final BigDecimal MILLIGRAMS_IN_A_GRAM = new BigDecimal("1000");
	public static final BigDecimal MILLIGRAMS_IN_A_KILOGRAM = new BigDecimal(
			"1000000");
	public static final BigDecimal MILLIGRAMS_IN_A_TONNE = new BigDecimal(
			"1000000000");

	// Instance fields.

	private BigDecimal milligrams;

	// Constructor.

	public MassConverter(BigDecimal milligrams) {
		this.setUnit(milligrams);
	}

	// Unit setter.

	public final MassConverter setUnit(BigDecimal unit) {
		if (unit.signum() == -1) {
			throw new InvalidParameterException("negative mass makes no sense!");
		}
		this.milligrams = unit;
		return this;
	}

	// Initialize with metric mass units.

	public static MassConverter fromMilligrams(double milligrams) {
		return MassConverter.fromMilligrams(new BigDecimal(Double
				.toString(milligrams)));
	}

	public static MassConverter fromMilligrams(BigDecimal milligrams) {
		return new MassConverter(milligrams);
	}

	public static MassConverter fromGrams(double grams) {
		return MassConverter.fromGrams(new BigDecimal(Double.toString(grams)));
	}

	public static MassConverter fromGrams(BigDecimal grams) {
		return new MassConverter(grams.multiply(MILLIGRAMS_IN_A_GRAM));
	}

	public static MassConverter fromKilograms(double kilograms) {
		return MassConverter.fromKilograms(new BigDecimal(Double
				.toString(kilograms)));
	}

	public static MassConverter fromKilograms(BigDecimal kilograms) {
		return new MassConverter(kilograms.multiply(MILLIGRAMS_IN_A_KILOGRAM));
	}

	public static MassConverter fromTonnes(double tonnes) {
		return MassConverter
				.fromTonnes(new BigDecimal(Double.toString(tonnes)));
	}

	public static MassConverter fromTonnes(BigDecimal tonnes) {
		return new MassConverter(tonnes.multiply(MILLIGRAMS_IN_A_TONNE));
	}

	// Output as metric mass units.

	public BigDecimal toMilligrams() {
		return this.milligrams;
	}

	public BigDecimal toGrams() {
		return this.milligrams.divide(MILLIGRAMS_IN_A_GRAM, DEFAULT_SCALE,
				DEFAULT_ROUNDING_MODE);
	}

	public BigDecimal toKilograms() {
		return this.milligrams.divide(MILLIGRAMS_IN_A_KILOGRAM, DEFAULT_SCALE,
				DEFAULT_ROUNDING_MODE);
	}

	public BigDecimal toTonnes() {
		return this.milligrams.divide(MILLIGRAMS_IN_A_TONNE, DEFAULT_SCALE,
				DEFAULT_ROUNDING_MODE);
	}

	// Output as a String.

	@Override
	public String toString() {

		if (this.milligrams.compareTo(MILLIGRAMS_IN_A_TONNE) >= 0) {
			return String.format("%.2f t", this.toTonnes().doubleValue());

		} else if (this.milligrams.compareTo(MILLIGRAMS_IN_A_KILOGRAM) >= 0) {
			return String.format("%.2f Kg", this.toKilograms().doubleValue());

		} else if (this.milligrams.compareTo(MILLIGRAMS_IN_A_GRAM) >= 0) {
			return String.format("%.2f g", this.toGrams().doubleValue());

		} else {
			return String.format("%.2f mg", this.toMilligrams().doubleValue());
		}
	}
}
