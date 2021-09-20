package com.diegopinheiro.pet_atividade1;

public class ResultLeaf extends ResultComponent implements ISubject {
	public double result;
	
	public ResultLeaf(double result) {
		this.result = result;
	}

	@Override
	public double getResult() {
		return result;
	}
	
	public void setValue(double value) {
		this.result = value;
	}
}
