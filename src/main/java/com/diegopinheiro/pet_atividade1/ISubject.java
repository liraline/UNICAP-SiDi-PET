package com.diegopinheiro.pet_atividade1;

public interface ISubject {
	void attach(IObserver observer);
	void dettach(IObserver observer);
	void notifyObervers();
}
