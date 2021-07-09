package com.game.entity;

public class Carro {
	Conductor conductor;
	int distanciaRecorrida; //metros
	int limite; //kilometros
	boolean enMarcha = true;
	
	public Carro(String nombreJugador) {
		conductor = new Conductor(nombreJugador);
		distanciaRecorrida = 0;
	}
	
	public int getLimite() {
		return limite;
	}

	public void setLimite(int limite) {
		this.limite = limite;
	}

	public void avanzar(int delta) {
		if(enMarcha && !alcanzarMeta() ) {
			distanciaRecorrida += delta;
			System.out.print("["+conductor.getNombre()+"] -> "+ distanciaRecorrida+" mts recorridos; ");
		}
	}
	
	public Conductor getConductor() {
		return conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}

	public int getDistanciaRecorrida() {
		return distanciaRecorrida;
	}

	public boolean alcanzarMeta() {
		if(distanciaRecorrida >= limite*1000) {
			Podio.notificarLlegada(this);
			enMarcha = false;
			return true;
		}
		return false;
	}
}
