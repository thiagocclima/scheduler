package com.thiago.scheduler.fee;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FeeATest {

	@Test
	public void shouldCalculateFeeEqualToo6() {
		FeeA feeA = new FeeA();
		BigDecimal feeToPay = feeA.calculate(new BigDecimal(100));

		Assertions.assertEquals(new BigDecimal("6.00"), feeToPay);
	}

}
