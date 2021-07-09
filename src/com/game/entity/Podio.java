package com.game.entity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.game.util.GeneradorReporte;

public class Podio {
	static List<Carro> ganadores;
	static boolean status = true;
	static final int NUMERO_GANADORES = 3;
	
	static {
		ganadores = new ArrayList<Carro>();
	}
	
	public static void notificarLlegada(Carro carro) {
		try {
			ganadores.add(carro);
			validarEstadoCarrera(ganadores.size());
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	static void validarEstadoCarrera(int n) throws IOException {
		if(n == NUMERO_GANADORES) {
			status = false;
			mostrarResumenPosiciones();
			GeneradorReporte.procesarInformacion(ganadores);
		}
	}
	
	public static boolean isCarreraActiva() {
		return status;
	}
	
	private static void mostrarResumenPosiciones() {
		System.out.println("\nPODIO:\n====================");
		for(int i = 0; i < ganadores.size(); i++) {
			System.out.println("Puesto # "+(i+1)+" => "+ganadores.get(i).getConductor().getNombre());
		}
		System.out.println("=====================");
	}
}
