package com.diegopinheiro.pet_atividade1;

public class FactoryOperationsSumThenMultiplication implements FactoryOperations {
	@Override
	public Operation createBottomOperation() {
		return new OperationSum();
	}

	@Override
	public Operation createTopOperation() {
		return new OperationMultiplication();
	}
}
