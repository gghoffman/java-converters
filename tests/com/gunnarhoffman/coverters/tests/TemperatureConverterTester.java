package com.gunnarhoffman.coverters.tests;

import com.gunnarhoffman.converters.TemperatureConverter;
import org.junit.Test;
import org.junit.Assert;

import java.math.BigDecimal;

public class TemperatureConverterTester {

    @Test
    public void testFahrenheitToCelsius() {
        final BigDecimal expected = new BigDecimal("0.0");
        TemperatureConverter actual = TemperatureConverter.fromFahrenheit(32.0);
        Assert.assertEquals(expected, actual.toCelsius());
    }

    @Test
    public void testCelsiusToFahrenheit() {
        final BigDecimal expected = new BigDecimal("32.0");
        TemperatureConverter actual = TemperatureConverter.fromCelsius(0);
        Assert.assertEquals(expected, actual.toFahrenheit());
    }

    @Test
    public void testKelvinToCelsius() {
        final BigDecimal expected = new BigDecimal("0.0");
        TemperatureConverter actual = TemperatureConverter.fromKelvin(273.15);
        Assert.assertEquals(expected, actual.toCelsius());
    }
}
