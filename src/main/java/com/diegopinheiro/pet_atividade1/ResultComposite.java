package com.diegopinheiro.pet_atividade1;

import java.util.List;
import java.util.ArrayList;

public class ResultComposite extends ResultComponent implements IObserver {
	private List<ResultComponent> children;
	Operation operation;
	double result;
	
	public ResultComposite(Operation operation) {
		this.children = new ArrayList<>();
		this.operation = operation;
	}

	@Override
	public double getResult() {
		if(operation instanceof OperationSum) {
			result = 0;
		} else {
			result = 1;
		}
		
		for(int i = 0; i < children.size(); i++) {
			result = operation.calculate(result, children.get(i).getResult());
		}
		
		return result;
	}
	
	public void addResult(ResultComponent component) {
		children.add(component);
		component.attach(this);
	}
	
	public void removeResult(ResultComponent component) {
		component.dettach(this);
		children.remove(component);
	}

	@Override
	public void update() {	
	}
}
