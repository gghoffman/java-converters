package com.gunnarhoffman.converters;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.InvalidParameterException;

/**
 * This class aids in conversion between all the various byte and bit
 * increments. The highest understood value for this class is a Terabyte. While
 * it supports values well into the range of Petabytes all sizes above a
 * Terabyte will be reported as a number of Terabytes. Negative values are not
 * supported except for use with the add* methods assuming it does not produce a
 * completely negative value for the current byte sum.
 * 
 * @author Gunnar Hoffman
 * 
 */
public class ByteConverter {

	// Constants

	public static int DEFAULT_SCALE = 100;
	public static int DEFAULT_ROUNDING_MODE = BigDecimal.ROUND_HALF_UP;

	public static final BigDecimal TEN_TWENTY_FOUR_TO_THE_FOURTH = new BigDecimal(
			"1099511627776");
	public static final BigDecimal TEN_TWENTY_FOUR_TO_THE_THIRD = new BigDecimal(
			"1073741824");
	public static final BigDecimal TEN_TWENTY_FOUR_TO_THE_SECOND = new BigDecimal(
			"1048576");
	public static final BigDecimal TEN_TWENTY_FOUR_TO_THE_FIRST = new BigDecimal(
			"1024");
	public static final BigDecimal EIGHT = new BigDecimal("8");

	// Instance fields

	private BigDecimal bytes;

	// Constructors

	private ByteConverter(BigDecimal bytes) {
		this.setBytes(bytes);
	}

	// Setters

	/**
	 * <p>
	 * Sets the raw byte value in the underlying data source for this class.
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
	 *            The number of bytes to operate over.
	 * @return An instance of this class containing the byte number.
	 */
	public final ByteConverter setBytes(BigDecimal number) {
		if (number.signum() == -1) {
			throw new InvalidParameterException(
					"negative bytes makes no sense!");
		}
		this.bytes = number;
		return this;
	}

	// Byte initializers

	public static ByteConverter fromTerabytes(double terabytes) {

		return ByteConverter.fromTerabytes(new BigDecimal(
				Double.toString(terabytes)));
	}

	public static ByteConverter fromTerabytes(BigDecimal terabytes) {

		BigDecimal calculator = new BigDecimal(terabytes.toString());
		calculator = calculator.multiply(ByteConverter.TEN_TWENTY_FOUR_TO_THE_FOURTH);
		return new ByteConverter(calculator);
	}

	public static ByteConverter fromGigabytes(double gigabytes) {

		return ByteConverter.fromGigabytes(new BigDecimal(
				Double.toString(gigabytes)));
	}

	public static ByteConverter fromGigabytes(BigDecimal gigabytes) {

		BigDecimal calculator = new BigDecimal(gigabytes.toString());
		calculator = calculator.multiply(ByteConverter.TEN_TWENTY_FOUR_TO_THE_THIRD);
		return new ByteConverter(calculator);
	}

	public static ByteConverter fromMegabytes(double megabytes) {

		return ByteConverter.fromMegabytes(new BigDecimal(
				Double.toString(megabytes)));
	}

	public static ByteConverter fromMegabytes(BigDecimal megabytes) {

		BigDecimal calculator = new BigDecimal(megabytes.toString());
		calculator = calculator.multiply(ByteConverter.TEN_TWENTY_FOUR_TO_THE_SECOND);
		return new ByteConverter(calculator);
	}

	public static ByteConverter fromKilobytes(double kilobytes) {

		return ByteConverter.fromKilobytes(new BigDecimal(
				Double.toString(kilobytes)));
	}

	public static ByteConverter fromKilobytes(BigDecimal kilobytes) {

		BigDecimal calculator = new BigDecimal(kilobytes.toString());
		calculator = calculator.multiply(ByteConverter.TEN_TWENTY_FOUR_TO_THE_FIRST);
		return new ByteConverter(calculator);
	}

	public static ByteConverter fromBytes(long bytes) {
		return ByteConverter.fromBytes(new BigDecimal(Long.toString(bytes)));
	}

	public static ByteConverter fromBytes(BigDecimal bytes) {
		return new ByteConverter(new BigDecimal(bytes.toString()));
	}

	// Bit initializers

	public static ByteConverter fromTerabits(double terabits) {

		return ByteConverter.fromTerabits(new BigDecimal(
				Double.toString(terabits)));
	}

	public static ByteConverter fromTerabits(BigDecimal terabits) {

		BigDecimal calculator = new BigDecimal(terabits.toString());
		calculator = calculator.multiply(ByteConverter.TEN_TWENTY_FOUR_TO_THE_FOURTH);
		calculator = calculator.divide(ByteConverter.EIGHT);
		return new ByteConverter(calculator);
	}

	public static ByteConverter fromGigabits(double gigabits) {

		return ByteConverter.fromGigabits(new BigDecimal(
				Double.toString(gigabits)));
	}

	public static ByteConverter fromGigabits(BigDecimal gigabits) {

		BigDecimal calculator = new BigDecimal(gigabits.toString());
		calculator = calculator.multiply(ByteConverter.TEN_TWENTY_FOUR_TO_THE_THIRD);
		calculator = calculator.divide(ByteConverter.EIGHT);
		return new ByteConverter(calculator);
	}

	public static ByteConverter fromMegabits(double megabits) {

		return ByteConverter.fromMegabits(new BigDecimal(
				Double.toString(megabits)));
	}

	public static ByteConverter fromMegabits(BigDecimal megabits) {

		BigDecimal calculator = new BigDecimal(megabits.toString());
		calculator = calculator.multiply(ByteConverter.TEN_TWENTY_FOUR_TO_THE_SECOND);
		calculator = calculator.divide(ByteConverter.EIGHT);
		return new ByteConverter(calculator);
	}

	public static ByteConverter fromKilobits(double kilobits) {
		return ByteConverter.fromKilobits(new BigDecimal(
				Double.toString(kilobits)));
	}

	public static ByteConverter fromKilobits(BigDecimal kilobits) {

		BigDecimal calculator = new BigDecimal(kilobits.toString());
		calculator = calculator.multiply(ByteConverter.TEN_TWENTY_FOUR_TO_THE_FIRST);
		calculator = calculator.divide(ByteConverter.EIGHT);
		return new ByteConverter(calculator);
	}

	// Addition and (via the use of negative numbers) subtraction

	public ByteConverter addBytes(long bytes) {
		this.setBytes(this.bytes.add(new BigDecimal(bytes)));
		return this;
	}

	public ByteConverter addKilobytes(double kilobytes) {
		this.setBytes(this.bytes.add(new BigDecimal(kilobytes).multiply(ByteConverter.TEN_TWENTY_FOUR_TO_THE_FIRST)));
		return this;
	}

	public ByteConverter addMegabytes(double megabytes) {
		this.setBytes(this.bytes.add(new BigDecimal(megabytes).multiply(ByteConverter.TEN_TWENTY_FOUR_TO_THE_SECOND)));
		return this;
	}

	public ByteConverter addGigabytes(double gigabytes) {
		this.setBytes(this.bytes.add(new BigDecimal(gigabytes).multiply(ByteConverter.TEN_TWENTY_FOUR_TO_THE_THIRD)));
		return this;
	}

	public ByteConverter addTerabytes(double terabytes) {
		this.setBytes(this.bytes.add(new BigDecimal(terabytes).multiply(ByteConverter.TEN_TWENTY_FOUR_TO_THE_FOURTH)));
		return this;
	}

	// Output as bytes

	public BigInteger toBytes() {
		return this.bytes.toBigInteger();
	}

	public BigDecimal toKilobytes() {
		return this.bytes.divide(ByteConverter.TEN_TWENTY_FOUR_TO_THE_FIRST,
				DEFAULT_SCALE, DEFAULT_ROUNDING_MODE);
	}

	public BigDecimal toMegabytes() {
		return this.bytes.divide(ByteConverter.TEN_TWENTY_FOUR_TO_THE_SECOND,
				DEFAULT_SCALE, DEFAULT_ROUNDING_MODE);
	}

	public BigDecimal toGigabytes() {
		return this.bytes.divide(ByteConverter.TEN_TWENTY_FOUR_TO_THE_THIRD,
				DEFAULT_SCALE, DEFAULT_ROUNDING_MODE);
	}

	public BigDecimal toTerabytes() {
		return this.bytes.divide(ByteConverter.TEN_TWENTY_FOUR_TO_THE_FOURTH,
				DEFAULT_SCALE, DEFAULT_ROUNDING_MODE);
	}

	// Output as bits

	public BigDecimal toKilobits() {
		return this.toKilobytes()
				.divide(ByteConverter.EIGHT, DEFAULT_SCALE,
						DEFAULT_ROUNDING_MODE);
	}

	public BigDecimal toMegabits() {
		return this.toMegabytes()
				.divide(ByteConverter.EIGHT, DEFAULT_SCALE,
						DEFAULT_ROUNDING_MODE);
	}

	public BigDecimal toGigabits() {
		return this.toGigabytes()
				.divide(ByteConverter.EIGHT, DEFAULT_SCALE,
						DEFAULT_ROUNDING_MODE);
	}

	public BigDecimal toTerabits() {
		return this.toTerabytes()
				.divide(ByteConverter.EIGHT, DEFAULT_SCALE,
						DEFAULT_ROUNDING_MODE);
	}

	// Output as a String

	@Override
	public String toString() {

		if (this.bytes.compareTo(ByteConverter.TEN_TWENTY_FOUR_TO_THE_FOURTH) >= 0) {
			return String.format("%.2f TB", this.toTerabytes()
					.doubleValue());

		} else if (this.bytes.compareTo(ByteConverter.TEN_TWENTY_FOUR_TO_THE_THIRD) >= 0) {
			return String.format("%.2f GB", this.toGigabytes()
					.doubleValue());

		} else if (this.bytes.compareTo(ByteConverter.TEN_TWENTY_FOUR_TO_THE_SECOND) >= 0) {
			return String.format("%.2f MB", this.toMegabytes()
					.doubleValue());

		} else if (this.bytes.compareTo(ByteConverter.TEN_TWENTY_FOUR_TO_THE_FIRST) >= 0) {
			return String.format("%.2f KB", this.toKilobytes()
					.doubleValue());

		} else {
			return String.format("%d B", this.bytes.intValue());
		}
	}
}