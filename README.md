java-converters
===============

This libraries facilitates the fast and easy conversion between various types of measurement.

No checked exceptions, no dependencies. Works with Java SE6 or newer.

This repository can be checked out as an Eclipse or an IntelliJ project. Running it will run all the packaged examples.

Conversions supported: Bytes and Bits, Volume, Temperature, Time, Distance

Examples:

System.out.println(ByteConverter.fromMegabytes(6000)
				.addGigabytes(-1.34)
				.toKilobytes()
				.floatValue());
				
Result: 4738908.0
