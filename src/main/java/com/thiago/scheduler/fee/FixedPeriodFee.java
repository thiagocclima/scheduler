package com.thiago.scheduler.fee;

import java.math.BigDecimal;

public abstract class FixedPeriodFee implements Fee {

	public abstract BigDecimal getPercentTax();

}
