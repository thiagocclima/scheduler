package com.thiago.scheduler.fee;

import java.math.BigDecimal;

public class FeeB extends FixedPeriodFee {

	private final BigDecimal percentTax = new BigDecimal(9);

	public FeeB(int daysBetween) {
		super(daysBetween);
		if (daysBetween < 1 || daysBetween > 10) {
			throw new IllegalArgumentException("The given value can just be scheduled for current day +1 to 10 days");
		}
	}

	@Override
	public BigDecimal getPercentTax() {
		return percentTax;
	}

	@Override
	public BigDecimal getValue(BigDecimal amount) {
		validateAmount(amount);
		return amount.multiply(percentTax.divide(new BigDecimal(100)));
	}
}
