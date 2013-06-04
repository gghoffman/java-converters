# Java-Converters

This library facilitates the fast and easy conversion between various types of measurement. No checked exceptions, no dependencies. Works with Java SE6 or newer.
This repository can be checked out as an Eclipse or an IntelliJ project. Running it will run all the packaged examples. Contributions and feedback are welcome!

Conversions supported: 
- Bytes and Bits
- Volume
- Temperature
- Time
- Distance
- Speed
- Mass

### As of now this project is incomplete, the following items are done:

- [x] ByteConverter
- [x] TemperatureConverter
- [x] TimeConverter
- [x] DistanceConverter
- [ ] SpeedConverter
- [x] MassConverter

- [ ] ByteConverter Tests
- [ ] TemperatureConverter Tests
- [ ] TimeConverter Tests
- [ ] DistanceConverter Tests
- [ ] SpeedConverter Tests
- [ ] MassConverter Tests

### Examples:

```java
System.out.println(ByteConverter.fromMegabytes(6000)
				.addGigabytes(-1.34)
				.toKilobytes()
				.floatValue());
```

Result: ``` 4738908.0 ```






