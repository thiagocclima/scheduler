package com.thiago.scheduler.fee;

import java.math.BigDecimal;

public interface Fee {

	BigDecimal calculate(BigDecimal amount);

}
