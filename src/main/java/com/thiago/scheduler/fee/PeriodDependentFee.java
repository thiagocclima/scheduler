package com.thiago.scheduler.fee;

import java.math.BigDecimal;

public abstract class PeriodDependentFee extends FeeCalculator {

	public PeriodDependentFee(int daysBetween) {
		super(daysBetween);
	}

}
