package com.thiago.scheduler.fee;

import java.math.BigDecimal;

public class FeeB extends FixedPeriodFee {

	private final BigDecimal percentTax = new BigDecimal(9);

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
