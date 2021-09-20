/**
 * @author Diego Pinheiro <diegompin@gmail.com>
 */

package com.diegopinheiro.pet_atividade1;

import org.junit.Assert;
import org.junit.Test;


public class Part4ObserverTest {
	
	@Test
	public void testObserverChangeValueLeafs() {
		ResultLeaf c1 = new ResultLeaf(1);
		ResultLeaf c2 = new ResultLeaf(2);
		
		ResultComponent resultComponent = buildResultComponent(c1, c2);
		
		double expected;
		double actual; 
		
		expected = 21;
		actual = resultComponent.getResult();
		Assert.assertEquals(expected, actual, 0.0001);
		
		c1.setValue(3);
		expected = 35;
		actual = resultComponent.getResult();
		Assert.assertEquals(expected, actual, 0.0001);
		
		c2.setValue(4);
		expected = 49;
		actual = resultComponent.getResult();
		Assert.assertEquals(expected, actual, 0.0001);
		
	}


	private ResultComponent buildResultComponent(ResultLeaf c1, ResultLeaf c2) {
		FactoryOperations operationCreator = new FactoryOperationsSumThenMultiplication();
		
		Operation bottomOperation = operationCreator.createBottomOperation();
		Operation topOperation = operationCreator.createTopOperation();
		
		ResultComposite bottomLeftResult = new ResultComposite(bottomOperation);
		
		
		bottomLeftResult.addResult(c1);
		bottomLeftResult.addResult(c2);
		
		ResultComposite bottomRightResult = new ResultComposite(bottomOperation);
		ResultLeaf c3 = new ResultLeaf(3);
		ResultLeaf c4 = new ResultLeaf(4);
		bottomRightResult.addResult(c3);
		bottomRightResult.addResult(c4);
		
		ResultComposite topResult = new ResultComposite(topOperation);
		topResult.addResult(bottomLeftResult);
		topResult.addResult(bottomRightResult);
		
		ResultComponent resultComponent = topResult;
		return resultComponent;
	}
	
	
	@Test
	public void testObserverAddChild() {
		FactoryOperations operationCreator = new FactoryOperationsSumThenMultiplication();
		
		Operation bottomOperation = operationCreator.createBottomOperation();
		Operation topOperation = operationCreator.createTopOperation();
		
		ResultComposite bottomLeftResult = new ResultComposite(bottomOperation);
		ResultLeaf c1 = new ResultLeaf(1);
		ResultLeaf c2 = new ResultLeaf(2);
		
		bottomLeftResult.addResult(c1);
		bottomLeftResult.addResult(c2);
		
		ResultComposite bottomRightResult = new ResultComposite(bottomOperation);
		ResultLeaf c3 = new ResultLeaf(3);
		ResultLeaf c4 = new ResultLeaf(4);
		bottomRightResult.addResult(c3);
		bottomRightResult.addResult(c4);
		
		ResultComposite topResult = new ResultComposite(topOperation);
		topResult.addResult(bottomLeftResult);
		topResult.addResult(bottomRightResult);
		
		ResultComponent resultComponent = topResult;
		
		double expected = 21;
		double actual = resultComponent.getResult();
		Assert.assertEquals(expected, actual, 0.0001);
		
		ResultLeaf c5 = new ResultLeaf(2);
		bottomLeftResult.addResult(c5);
		expected = 35;
		actual = resultComponent.getResult();
		Assert.assertEquals(expected, actual, 0.0001);
		
	}
	
}
