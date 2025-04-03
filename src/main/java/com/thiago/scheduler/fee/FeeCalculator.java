package com.thiago.scheduler.fee;

import java.math.BigDecimal;

public interface FeeCalculator {

	BigDecimal getValue(BigDecimal amount);

}
