package com.thiago.scheduler.fee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class FeeCTest {

	@Test
	public void shouldMatchPercentualFor11To20Days() {
		FeeC feeC = new FeeC(15);
		assertEquals(new BigDecimal("8.20"), feeC.getValue(new BigDecimal("100")));
		assertEquals(new BigDecimal("16.40"), feeC.getValue(new BigDecimal("200")));
	}

	@Test
	public void shouldMatchPercentualFor21To30Days() {
		FeeC feeC = new FeeC(25);
		assertEquals(new BigDecimal("6.90"), feeC.getValue(new BigDecimal("100")));
		assertEquals(new BigDecimal("13.80"), feeC.getValue(new BigDecimal("200")));
	}

	@Test
	public void shouldMatchPercentualFor31To40Days() {
		FeeC feeC = new FeeC(35);
		assertEquals(new BigDecimal("4.70"), feeC.getValue(new BigDecimal("100")));
		assertEquals(new BigDecimal("9.40"), feeC.getValue(new BigDecimal("200")));
	}

	@Test
	public void shouldMatchPercentualForOver40Days() {
		FeeC feeC = new FeeC(45);
		assertEquals(new BigDecimal("1.70"), feeC.getValue(new BigDecimal("100")));
		assertEquals(new BigDecimal("3.40"), feeC.getValue(new BigDecimal("200")));
	}

	@Test
	public void shouldMatchPercentualForThrowsException() {
		assertThrows(IllegalArgumentException.class, () -> new FeeC(5));
		assertThrows(IllegalArgumentException.class, () -> new FeeC(10));
	}

}
