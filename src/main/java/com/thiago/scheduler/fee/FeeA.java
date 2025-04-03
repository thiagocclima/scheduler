package com.thiago.scheduler.fee;

import java.math.BigDecimal;

public class FeeA extends FixedPeriodFee {

	private final BigDecimal preFixedTax = new BigDecimal(3);
	private final BigDecimal percentTax = new BigDecimal(3);

	public FeeA(int daysBetween) {
		super(daysBetween);
		if (daysBetween != 0) {
			throw new IllegalArgumentException("The given value can just be scheduled for current day");
		}
	}

	@Override
	public BigDecimal getValue(BigDecimal amount) {
		validateAmount(amount);
		return amount
				.multiply(percentTax.divide(new BigDecimal(100)))
				.add(preFixedTax);
	}

	@Override
	public BigDecimal getPercentTax() {
		return percentTax;
	}
}
