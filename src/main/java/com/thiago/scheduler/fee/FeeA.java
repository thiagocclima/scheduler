package com.thiago.scheduler.fee;

import java.math.BigDecimal;

public class FeeA extends FixedPeriodFee {

	private final BigDecimal preFixedTax = new BigDecimal(3);
	private final BigDecimal percentTax = new BigDecimal(3);

	@Override
	public BigDecimal calculate(BigDecimal amount) {
		return amount.multiply(percentTax.divide(new BigDecimal(100))).add(preFixedTax);
	}

	@Override
	public BigDecimal getPercentTax() {
		return percentTax;
	}
}
