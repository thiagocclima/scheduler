package com.thiago.scheduler.fee;

import java.math.BigDecimal;

public class FeeCalculatorFactory {

	private FeeCalculatorFactory(){}

	public static FeeCalculator getInstance(BigDecimal amount, int daysBetween) {
		if (amount.compareTo(BigDecimal.valueOf(1000)) <= 0) {
			return new FeeA(daysBetween);
		}
		if (amount.compareTo(BigDecimal.valueOf(1001)) >= 0
				&& amount.compareTo(BigDecimal.valueOf(2000)) <= 0) {
			return new FeeB(daysBetween);
		}
		if (amount.compareTo(BigDecimal.valueOf(2000)) > 0) {
			return new FeeC(daysBetween);
		}

		throw new IllegalArgumentException("Amount must be greater than ZERO");
	}
}
