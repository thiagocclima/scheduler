package com.thiago.scheduler.fee;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

class FeeCalculatorFactoryTest {

	@Test
	void shouldReturnFeeAForAmountLessThanOrEqualTo1000() {
		BigDecimal amount = BigDecimal.valueOf(999);
		int daysBetween = 0;

		FeeCalculator calculator = FeeCalculatorFactory.getInstance(amount, daysBetween);

		assertTrue(calculator instanceof FeeA);
	}

	@Test
	void shouldReturnFeeAForAmountEqualTo1000() {
		BigDecimal amount = BigDecimal.valueOf(1000);
		int daysBetween = 0;

		FeeCalculator calculator = FeeCalculatorFactory.getInstance(amount, daysBetween);

		assertTrue(calculator instanceof FeeA);
	}

	@Test
	void shouldReturnFeeBForAmountBetween1001And2000() {
		BigDecimal amount = BigDecimal.valueOf(1500);
		int daysBetween = 10;

		FeeCalculator calculator = FeeCalculatorFactory.getInstance(amount, daysBetween);

		assertTrue(calculator instanceof FeeB);
	}

	@Test
	void shouldReturnFeeBForAmountEqualTo1001() {
		BigDecimal amount = BigDecimal.valueOf(1001);
		int daysBetween = 10;

		FeeCalculator calculator = FeeCalculatorFactory.getInstance(amount, daysBetween);

		assertTrue(calculator instanceof FeeB);
	}

	@Test
	void shouldReturnFeeBForAmountEqualTo2000() {
		BigDecimal amount = BigDecimal.valueOf(2000);
		int daysBetween = 10;

		FeeCalculator calculator = FeeCalculatorFactory.getInstance(amount, daysBetween);

		assertTrue(calculator instanceof FeeB);
	}

	@Test
	void shouldReturnFeeCForAmountGreaterThan2000() {
		BigDecimal amount = BigDecimal.valueOf(2001);
		int daysBetween = 11;

		FeeCalculator calculator = FeeCalculatorFactory.getInstance(amount, daysBetween);

		assertTrue(calculator instanceof FeeC);
	}

	@Test
	void shouldReturnFeeCForAmountGreaterThan2000LargeAmount() {
		BigDecimal amount = BigDecimal.valueOf(1000000);
		int daysBetween = 11;

		FeeCalculator calculator = FeeCalculatorFactory.getInstance(amount, daysBetween);

		assertTrue(calculator instanceof FeeC);
	}

	@Test
	void shouldThrowsIllegalArgumentExceptionForAmountEqualTo0() {
		BigDecimal amount = BigDecimal.ZERO;
		int daysBetween = 10;

		assertThrows(IllegalArgumentException.class, () -> FeeCalculatorFactory.getInstance(amount, daysBetween));
	}

	@Test
	void shouldThrowsIllegalArgumentExceptionForNegativeAmount() {
		BigDecimal amount = BigDecimal.valueOf(-10);
		int daysBetween = 10;

		assertThrows(IllegalArgumentException.class, () -> FeeCalculatorFactory.getInstance(amount, daysBetween));
	}
}
