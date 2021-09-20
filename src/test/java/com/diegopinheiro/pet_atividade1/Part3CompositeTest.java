/**
 * @author Diego Pinheiro <diegompin@gmail.com>
 */

package com.diegopinheiro.pet_atividade1;

import org.junit.Assert;
import org.junit.Test;

public class Part3CompositeTest {
	@Test
	public void test01CompositeLeafOnly() {
		double result = 3;
		ResultComponent resultComponent = new ResultLeaf(result);
		double actual = resultComponent.getResult();
		double expected = 3;
		Assert.assertEquals(expected, actual, 0.001);
	}

	@Test
	public void test02SumThenMultiplication() {
		FactoryOperations operationsFactory = new FactoryOperationsSumThenMultiplication();
		ResultComposite topResult = buildResultComponent(operationsFactory);

		ResultComponent resultComponent = topResult;

		double actual = resultComponent.getResult();
		double expected = 21;
		Assert.assertEquals(expected, actual, 0.001);
	}

	@Test
	public void test03MultiplicationThenSum() {
		FactoryOperations operationsFactory = new FactoryOperationsMultiplicationThenSum();
		ResultComposite topResult = buildResultComponent(operationsFactory);

		ResultComponent resultComponent = topResult;

		double actual = resultComponent.getResult();
		double expected = 14;
		Assert.assertEquals(expected, actual, 0.001);
	}

	private ResultComposite buildResultComponent(FactoryOperations operationsFactory) {
		Operation bottomOperationOperation = operationsFactory.createBottomOperation();
		Operation topOperation = operationsFactory.createTopOperation();

		
		double leafValueLeft; 
		double leafValueRight;
		
		leafValueLeft = 1;
		leafValueRight = 2;
		ResultComposite bottomLeftResult = buildComposite(bottomOperationOperation, leafValueLeft, leafValueRight);
		
		leafValueLeft = 3;
		leafValueRight = 4;
		ResultComposite bottomRightResult = buildComposite(bottomOperationOperation, leafValueLeft, leafValueRight);

		ResultComposite topResult = new ResultComposite(topOperation);
		topResult.addResult(bottomLeftResult);
		topResult.addResult(bottomRightResult);
		return topResult;
	}

	private ResultComposite buildComposite(Operation operation, double leafValueLeft, double leafValueRight) {
		ResultComposite bottomLeftResult = new ResultComposite(operation);
		bottomLeftResult.addResult(new ResultLeaf(leafValueLeft));
		bottomLeftResult.addResult(new ResultLeaf(leafValueRight));
		return bottomLeftResult;
	}

}
