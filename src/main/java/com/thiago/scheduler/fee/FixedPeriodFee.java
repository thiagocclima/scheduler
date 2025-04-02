package com.thiago.scheduler.fee;

import java.math.BigDecimal;

public abstract class FixedPeriodFee implements Fee {

	protected abstract BigDecimal getPercentTax();

}
