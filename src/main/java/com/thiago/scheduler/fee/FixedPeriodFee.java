package com.thiago.scheduler.fee;

import java.math.BigDecimal;

public abstract class FixedPeriodFee extends FeeCalculator {

	public FixedPeriodFee(int daysBetween) {
		super(daysBetween);
	}

}
