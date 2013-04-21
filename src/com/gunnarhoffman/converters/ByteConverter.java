package com.gunnarhoffman.converters;

public class ByteConverter {

	private long bytes;

	private ByteConverter(long bytes) {
		this.bytes = bytes;
	}

	public static ByteConverter fromGigabytes(double gigabytes) {
		return new ByteConverter((long) (1024 * 1024 * 1024 * gigabytes));
	}

	public static ByteConverter fromMegabytes(double megabytes) {
		return new ByteConverter((long) (1024 * 1024 * megabytes));
	}

	public static ByteConverter fromKilobytes(double killobytes) {
		return new ByteConverter((long) (1024 * killobytes));
	}

	public static ByteConverter fromBytes(long bytes) {
		return new ByteConverter(bytes);
	}

	public static ByteConverter fromGigabits(double gigabytes) {
		return new ByteConverter((long) (1024 * 1024 * 1024 * gigabytes) / 8);
	}

	public static ByteConverter fromMegabits(double megabytes) {
		return new ByteConverter((long) (1024 * 1024 * megabytes) / 8);
	}

	public static ByteConverter fromKilobits(double killobytes) {
		return new ByteConverter((long) (1024 * killobytes) / 8);
	}

	public ByteConverter addBytes(long bytes) {
		this.bytes += bytes;
		return this;
	}
	
	// TODO More add methods

	public long toBytes() {
		return this.bytes;
	}

	public double toKilobytes() {
		return this.bytes / 1024.0;
	}

	public double toMegabytes() {
		return this.bytes / 1024.0 / 1024.0;
	}

	public double toGigabytes() {
		return this.bytes / 1024.0 / 1024.0 / 1024.0;
	}

	public double toKilobits() {
		return (this.bytes / 1024.0) * 8;
	}

	public double toMegabits() {
		return (this.bytes / 1024.0 / 1024.0) * 8;
	}

	public double toGigabits() {
		return (this.bytes / 1024.0 / 1024.0 / 1024.0) * 8;
	}

	@Override
	public String toString() {
		double value;
		if ((value = this.toGigabytes()) > 1) {
			return String.format("%.2f GB", value);

		} else if ((value = this.toMegabytes()) > 1) {
			return String.format("%.2f MB", value);

		} else if ((value = this.toKilobytes()) > 1) {
			return String.format("%.2f KB", value);

		} else {
			return String.format("%d B", this.bytes);
		}
	}
}