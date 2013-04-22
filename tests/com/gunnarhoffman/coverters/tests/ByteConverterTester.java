package com.gunnarhoffman.coverters.tests;

import junit.framework.Assert;

import org.junit.Test;

import com.gunnarhoffman.converters.ByteConverter;

public final class ByteConverterTester {

	@Test
	public void testBytesToBytes() {
		final long in = 1264978;
		Assert.assertEquals(ByteConverter.fromBytes(in).toBytes().longValue(), in);
	}
}
