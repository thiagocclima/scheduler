package com.thiago.scheduler.transaction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.thiago.scheduler.fee.FeeCalculator;
import com.thiago.scheduler.fee.FeeCalculatorFactory;

import lombok.Getter;

@Getter
public class Transaction {
	private final Long id;
	private final BigDecimal amount;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private final LocalDate date;
	private final BigDecimal percentTax;
	private final BigDecimal feeValue;
	private final BigDecimal total;

	public Transaction(@JsonProperty("amount") BigDecimal amount, @JsonProperty("date") LocalDate date) {
		this.id = null;
		this.amount = amount;
		this.date = date;

		FeeCalculator feeCalculator = FeeCalculatorFactory.getInstance(amount, getDaysBetween(date));
		this.percentTax = feeCalculator.getPercentTax();
		this.feeValue = feeCalculator.getValue(amount);
		this.total = amount.add(feeValue);
	}

	private Transaction(Long id, BigDecimal amount, LocalDate date, BigDecimal percentTax,
						BigDecimal feeValue, BigDecimal total) {
		this.id = id;
		this.amount = amount;
		this.date = date;
		this.percentTax = percentTax;
		this.feeValue = feeValue;
		this.total = total;
	}

	public static Transaction createTransaction(Long id, BigDecimal amount, LocalDate date, BigDecimal percentTax,
												BigDecimal feeValue, BigDecimal total) {
		return new Transaction(id, amount, date, percentTax, feeValue, total);
	}

	private static int getDaysBetween(LocalDate date) {
		LocalDate today = LocalDate.now();
		Long days = ChronoUnit.DAYS.between(today, date);
		return days.intValue();
	}
}
