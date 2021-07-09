package com.game.entity;
import java.util.ArrayList;
import java.util.List;

public class Pista {
	List<Carro> carros;
	int limite;

	public Pista(int limite) {
		carros = new ArrayList<Carro>();
		this.limite = limite;
	}
	

	public List<Carro> getCarros() {
		return carros;
	}

	public void agregarCarro(Carro carro) {
		carro.setLimite(limite);
		carros.add(carro);
	}
	
}
