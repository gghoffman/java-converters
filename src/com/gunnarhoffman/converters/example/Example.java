package com.gunnarhoffman.converters.example;

import com.gunnarhoffman.converters.ByteConverter;
import com.gunnarhoffman.converters.DistanceConverter;
import com.gunnarhoffman.converters.TimeConverter;

public class Example {

	public static void main(String[] args) {

		System.out.println(ByteConverter.fromMegabytes(6000)
				.addGigabytes(-1.34));

		System.out.println(TimeConverter.fromWeeks(467));

		System.out.println(DistanceConverter.fromKilometers(460000000));
	}
}
