package com.diegopinheiro.pet_atividade1;

public class FactoryOperationsMultiplicationThenSum implements FactoryOperations {
	@Override
	public Operation createBottomOperation() {
		return new OperationMultiplication();
	}

	@Override
	public Operation createTopOperation() {
		return new OperationSum();
	}

}
