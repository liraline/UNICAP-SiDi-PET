package com.diegopinheiro.pet_atividade1;

import java.util.*;

public abstract class ResultComponent implements ISubject {
	protected List<IObserver> observersList = new ArrayList<>();	
	public abstract double getResult();
	
	@Override
	public void attach(IObserver observer) {
		observersList.add(observer);		
	}

	@Override
	public void dettach(IObserver observer) {
		observersList.remove(observer);
		
	}

	@Override
	public void notifyObervers() {		
		for(IObserver observer : observersList) {
			observer.update();
		}			
	}
}
