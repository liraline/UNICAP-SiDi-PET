/**
 * @author Diego Pinheiro <diegompin@gmail.com>
 */

package com.diegopinheiro.pet_atividade1;

import org.junit.Assert;
import org.junit.Test;

public class Part1StrategyTest {

	@Test
	public void test01OperationSum() {
		double a = 10;
		double b = 20;
		Operation operation = new OperationSum();
		double actual = operation.calculate(a, b);
		double expected = 30;
		Assert.assertEquals(expected, actual, 0.0001);
	}

	@Test
	public void test02OperationMultiplication() {
		double a = 10;
		double b = 20;
		Operation operation = new OperationMultiplication();
		double actual = operation.calculate(a, b);
		double expected = 200;
		Assert.assertEquals(expected, actual, 0.0001);
	}
}
