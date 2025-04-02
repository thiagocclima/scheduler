package com.thiago.scheduler.fee;

import java.math.BigDecimal;
import java.util.Objects;

public class FeeA extends FixedPeriodFee {

	private final BigDecimal preFixedTax = new BigDecimal(3);
	private final BigDecimal percentTax = new BigDecimal(3);

	@Override
	public BigDecimal calculate(BigDecimal amount) {
		if (Objects.isNull(amount) || amount.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("Amount must be not null and greater than zero");
		}
		return amount
				.multiply(percentTax.divide(new BigDecimal(100)))
				.add(preFixedTax);
	}

	@Override
	public BigDecimal getPercentTax() {
		return percentTax;
	}
}
