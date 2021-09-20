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
		return result;
	}
	
	public void addResult(ResultComponent component) {
		children.add(component);
		
		/*
		 * everytime a new component is added as a ResultComposite child
		 * this ResultComposite is attached to the Observer list and it needs
		 * to be notified of this operation in order to update its result
		 */
		
		component.attach(this);
		component.notifyObervers();
	}
	
	public void removeResult(ResultComponent component) {
		/*
		 * everytime a component is removed from a ResultComposite children
		 * this ResultComposite is dettached from the Observer list and it needs
		 * to be notified of this operation in order to update its result
		 */
		
		component.dettach(this);
		component.notifyObervers();
		children.remove(component);
	}

	@Override
	public void update() {
		result = operation instanceof OperationSum ?  0 : 1;
		
		for(int i = 0; i < children.size(); i++) {
			result = operation.calculate(result, children.get(i).getResult());
		}
		
		/*
		 * everytime a ResultComposite updates its result it needs to notify
		 * all its Observers so they can update their results too
		 */
		
		super.notifyObervers();
	}
}
