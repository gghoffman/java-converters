package com.gunnarhoffman.converters.example;

import com.gunnarhoffman.converters.ByteConverter;

public class Example {

	public static void main(String[] args) {

		System.out.println(ByteConverter.fromMegabytes(6000)
				.addGigabytes(-1.34)
				.toKilobytes()
				.floatValue());
	}
}
