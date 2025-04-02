package com.thiago.scheduler.fee;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class FixedPeriodFee implements Fee {

	@Override
	public BigDecimal calculate(BigDecimal amount) {
		return BigDecimal.ZERO;
	}

	public void validateAmount(BigDecimal amount) {
		if (Objects.isNull(amount) || amount.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("Amount must be not null and greater than zero");
		}
	}

	public abstract BigDecimal getPercentTax();

}
