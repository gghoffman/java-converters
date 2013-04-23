package com.gunnarhoffman.coverters.tests;

import junit.framework.Assert;

import org.junit.Test;

import com.gunnarhoffman.converters.TimeConverter;

public class TimeConverterTester {

	@Test
	public void testWeeksToMinutes() {
		Assert.assertEquals(TimeConverter.fromWeeks(1)
											.toMinutes()
											.intValue(), 10080);
	}
}
