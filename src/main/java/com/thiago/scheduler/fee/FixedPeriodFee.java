package com.thiago.scheduler.fee;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class FixedPeriodFee implements FeeCalculator {

	protected final int daysBetween;

	public FixedPeriodFee(int daysBetween) {
		this.daysBetween = daysBetween;
	}

	@Override
	public BigDecimal getValue(BigDecimal amount) {
		return BigDecimal.ZERO;
	}

	public void validateAmount(BigDecimal amount) {
		if (Objects.isNull(amount) || amount.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("Amount must be not null and greater than zero");
		}
	}

	public abstract BigDecimal getPercentTax();

}
