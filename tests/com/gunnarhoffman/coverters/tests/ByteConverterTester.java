package com.gunnarhoffman.coverters.tests;

import junit.framework.Assert;

import org.junit.Test;

import com.gunnarhoffman.converters.ByteConverter;

import java.math.BigInteger;

public final class ByteConverterTester {

	@Test
	public void testBytesToBytes() {
		final long in = 1264978;
		Assert.assertEquals(ByteConverter.fromBytes(in).toBytes().longValue(), in);
	}

    @Test
    public void testAddKilobyteToOneThousandBytes() {
        final BigInteger in = BigInteger.valueOf(2024);
        Assert.assertEquals(ByteConverter.fromBytes(1000).addKilobytes(1).toBytes(), in);
    }
}
