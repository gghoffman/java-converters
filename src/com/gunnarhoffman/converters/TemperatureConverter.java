package com.gunnarhoffman.converters;

import java.math.BigDecimal;

/**
 * This class aids in conversion between various forms of measuring temperature.
 * The units this class handles are Kelvin, Celsius, and Fahrenheit.
 *
 * @author Blake Hair
 */
public class TemperatureConverter {

    // Constants

    private static final BigDecimal five = new BigDecimal("5.0");
    private static final BigDecimal nine = new BigDecimal("9.0");
    private static final BigDecimal thirtyTwo = new BigDecimal("32.0");
    private static final BigDecimal twoSeventyThree = new BigDecimal("273.15");

    private enum Unit {
        Kelvin, Celsius, Fahrenheit
    }

    // Instance fields
    private BigDecimal degrees;
    private Unit unit;

    // Constructors

    private TemperatureConverter(BigDecimal degrees) {
        this.setDegrees(degrees);
        this.setUnit(Unit.Celsius);
    }

    /**
     * Sets the raw number of degrees.
     * <p/>
     * This method is final to protect the constructor from undefined behavior
     * should this class be extended.
     *
     * @param number The number of degrees represented.
     * @return An instance of this class containing the number of degrees.
     */
    private final TemperatureConverter setDegrees(BigDecimal number) {
        this.degrees = number;
        return this;
    }

    private final TemperatureConverter setUnit(Unit type) {
        this.unit = type;
        return this;
    }

    public Unit getUnit() {
        return this.unit;
    }

    // Initializers

    public static TemperatureConverter fromCelsius(double degreesCelsius) {
        return TemperatureConverter.fromCelsius(new BigDecimal(Double.toString(degreesCelsius)));
    }

    public static TemperatureConverter fromCelsius(BigDecimal degreesCelsius) {
        return new TemperatureConverter(degreesCelsius);
    }

    public static TemperatureConverter fromFahrenheit(double degreesFahrenheit) {
        return TemperatureConverter.fromFahrenheit(new BigDecimal(Double.toString(degreesFahrenheit)));
    }

    public static TemperatureConverter fromFahrenheit(BigDecimal degreesFahrenheit) {
        TemperatureConverter fahrenheitConverter = new TemperatureConverter(degreesFahrenheit);
        fahrenheitConverter.setUnit(Unit.Fahrenheit);
        return fahrenheitConverter;
    }

    public static TemperatureConverter fromKelvin(double degreesKelvin) {
        return TemperatureConverter.fromKelvin(new BigDecimal(Double.toString(degreesKelvin)));
    }

    public static TemperatureConverter fromKelvin(BigDecimal degreesKelvin) {
        TemperatureConverter kelvinConverter = new TemperatureConverter(degreesKelvin);
        kelvinConverter.setUnit(Unit.Kelvin);
        return kelvinConverter;
    }

    // Output as Celsius

    public BigDecimal toCelsius() {
        if (this.getUnit().equals(Unit.Fahrenheit)) {
            return this.degrees.subtract(thirtyTwo).multiply(five).divide(nine);
        }
        if (this.getUnit().equals(Unit.Kelvin)) {
            return this.degrees.subtract(twoSeventyThree).setScale(1, BigDecimal.ROUND_DOWN);
        }
        return this.degrees;
    }

    // Output as Fahrenheit

    public BigDecimal toFahrenheit() {
        if (this.getUnit().equals(Unit.Celsius)) {
            return this.degrees.multiply(nine).divide(five).add(thirtyTwo);
        }
        if (this.getUnit().equals(Unit.Kelvin)) {
            return this.toCelsius().subtract(twoSeventyThree).setScale(1, BigDecimal.ROUND_DOWN);
        }
        return this.degrees;
    }

    // Output as Kelvin

    public BigDecimal toKelvin() {
        if (this.getUnit().equals(Unit.Celsius)) {
            return this.degrees.add(twoSeventyThree);
        }
        if (this.getUnit().equals(Unit.Fahrenheit)) {
            return this.toCelsius().add(twoSeventyThree).setScale(1, BigDecimal.ROUND_DOWN);
        }
        return this.degrees;
    }

}
