/**
 * @author Diego Pinheiro <diegompin@gmail.com>
 */

package com.diegopinheiro.pet_atividade1;

import org.junit.Assert;
import org.junit.Test;

public class Part2FactoryOperationsTest {
	
	@Test
	public void test01FactorySumThenMultiplicationBottomOperation() {
		FactoryOperations operationCreator = new FactoryOperationsSumThenMultiplication();
		Operation operation = operationCreator.createBottomOperation();
		Assert.assertTrue(operation instanceof OperationSum);
	}
	
	@Test
	public void test02FactorySumThenMultiplicationTopOperation() {
		FactoryOperations operationCreator = new FactoryOperationsSumThenMultiplication();
		Operation operation = operationCreator.createTopOperation();
		Assert.assertTrue(operation instanceof OperationMultiplication);
	}
	
	@Test
	public void test03FactoryMultiplicationThenSumBottomOperation() {
		FactoryOperations operationCreator = new FactoryOperationsMultiplicationThenSum();
		Operation operation = operationCreator.createBottomOperation();
		Assert.assertTrue(operation instanceof OperationMultiplication);
	}
	
	@Test
	public void test04FactoryMultiplicationThenSumTopOperation() {
		FactoryOperations operationCreator = new FactoryOperationsMultiplicationThenSum();
		Operation operation = operationCreator.createTopOperation();
		Assert.assertTrue(operation instanceof OperationSum);
	}
}
