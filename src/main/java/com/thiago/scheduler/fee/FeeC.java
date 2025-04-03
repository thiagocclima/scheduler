package com.thiago.scheduler.fee;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FeeC extends PeriodDependentFee {

	private static final BigDecimal PERCENT_TAX_1 = new BigDecimal("8.2");
	private static final BigDecimal PERCENT_TAX_2 = new BigDecimal("6.9");
	private static final BigDecimal PERCENT_TAX_3 = new BigDecimal("4.7");
	private static final BigDecimal PERCENT_TAX_4 = new BigDecimal("1.7");

	private BigDecimal percentTax;

	public FeeC(int daysBetween) {
		super(daysBetween);
		setPercentTax();
	}

	@Override
	public BigDecimal getValue(BigDecimal amount) {
		validateAmount(amount);
		return amount
				.multiply(percentTax.divide(new BigDecimal(100)))
				.setScale(2, RoundingMode.HALF_UP);
	}

	@Override
	public BigDecimal getPercentTax() {
		return percentTax;
	}

	private void setPercentTax() {
		if (daysBetween < 11) {
			throw new IllegalArgumentException("The given value can just be scheduled within more than 10 days");
		}

		if (daysBetween >= 11 && daysBetween <= 20) {
			this.percentTax = PERCENT_TAX_1;
		} else if (daysBetween >= 21 && daysBetween <= 30) {
			this.percentTax = PERCENT_TAX_2;
		} else if (daysBetween >= 31 && daysBetween <= 40) {
			this.percentTax = PERCENT_TAX_3;
		} else if (daysBetween > 40) {
			this.percentTax = PERCENT_TAX_4;
		}
	}
}
