package com.thiago.scheduler.fee;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FeeBTest {

	@Test
	public void shouldCalculateFeeEqualToo9() {
		FeeB feeB = new FeeB();
		BigDecimal feeToPay = feeB.getValue(new BigDecimal(100));

		assertEquals(new BigDecimal("9.00"), feeToPay);
	}

	@Test
	public void shouldNotCalculateForNullAmount() {
		FeeB feeB = new FeeB();
		Assertions.assertThrows(IllegalArgumentException.class, () -> feeB.getValue(null));
	}

	@Test
	void shouldNotCalculateForNegativeAmount() {
		FeeB feeB = new FeeB();
		BigDecimal amount = new BigDecimal(-100);
		Assertions.assertThrows(IllegalArgumentException.class, () -> feeB.getValue(amount));
	}

	@Test
	void shouldCalculateForDecimalAmount() {
		FeeB feeB = new FeeB();

		BigDecimal amount = new BigDecimal("50.50");
		BigDecimal expected = new BigDecimal("4.545");
		BigDecimal actual = feeB.getValue(amount);
		assertEquals(expected.setScale(3, BigDecimal.ROUND_HALF_UP), actual.setScale(3, BigDecimal.ROUND_HALF_UP));
	}

}
