package com.thiago.scheduler.fee;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FeeATest {

	@Test
	public void shouldCalculateFeeEqualToo6() {
		FeeA feeA = new FeeA(0);
		BigDecimal feeToPay = feeA.getValue(new BigDecimal(100));

		assertEquals(new BigDecimal("6.00"), feeToPay);
	}

	@Test
	public void shouldNotCalculateForNullAmount() {
		FeeA feeA = new FeeA(0);
		Assertions.assertThrows(IllegalArgumentException.class, () -> feeA.getValue(null));
	}

	@Test
	void shouldNotCalculateForNegativeAmount() {
		FeeA feeA = new FeeA(0);
		BigDecimal amount = new BigDecimal(-100);
		Assertions.assertThrows(IllegalArgumentException.class, () -> feeA.getValue(amount));
	}

	@Test
	void shouldCalculateForDecimalAmount() {
		FeeA feeA = new FeeA(0);
		BigDecimal amount = new BigDecimal("50.5");
		BigDecimal expected = new BigDecimal("4.515"); // 50.5 * 0.03 + 3
		assertEquals(expected.setScale(3, BigDecimal.ROUND_HALF_UP), feeA.getValue(amount).setScale(3, BigDecimal.ROUND_HALF_UP));
	}

}
