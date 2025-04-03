package com.thiago.scheduler.fee;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class FeeCalculator {

	protected final int daysBetween;

	public FeeCalculator(int daysBetween) {
		this.daysBetween = daysBetween;
	}

	protected void validateAmount(BigDecimal amount) {
		if (Objects.isNull(amount) || amount.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("Amount must be not null and greater than zero");
		}
	}

	public abstract BigDecimal getValue(BigDecimal amount);

	public abstract BigDecimal getPercentTax();

}
