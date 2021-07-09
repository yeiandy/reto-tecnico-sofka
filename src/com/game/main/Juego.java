package com.game.main;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

import com.game.entity.Carro;
import com.game.entity.Pista;
import com.game.entity.Podio;

public class Juego {
	Pista pista;
	final static int LIMITE_PISTA = 2; //2 KM
	final static int MINIMO_JUGADORES = 3;
	String idJuego;
	static Scanner input = new Scanner(System.in);
	
	public Juego() {
		pista = new Pista(LIMITE_PISTA);
		UUID uuid = UUID.randomUUID();
        idJuego = uuid.toString();
	}
	
	public int lanzarDado() {
		Random r = new Random();
		int valorGeneado = r.nextInt(6)+1;
		return valorGeneado;
	}
	
	public void crearJugador(String nombre) {
		Carro carro = new Carro(nombre);
		pista.agregarCarro(carro);
	}
	
	public void avanzarCarros() {
		for(int i = 0; i < pista.getCarros().size(); i++) {
			Carro carro = pista.getCarros().get(i);
			carro.avanzar(lanzarDado()*100);
		}
		System.out.println("");
	}
	
	public static void mensajeBienvenida() {
		System.out.println("<< Bienvenido/a a Carrera de Autos [Pista de "+LIMITE_PISTA+" KM] >>");
        System.out.println("---------------------------------------------------\n");
	}
	
	public static void crearJugadores(Juego juego) {
        int nPlayers = registrarCantidadJugadores();   
        registrarNombres(juego, input, nPlayers);
    }

	private static int registrarCantidadJugadores() {
		System.out.print("Ingrese número de jugadores (mínimo 3): ");
		int nPlayers = 0;
		while((nPlayers = Integer.parseInt(input.nextLine().trim())) < 3) {
			 System.out.println("Ingrese número de jugadores (mínimo 3):");
        }
		return nPlayers;
	}

	private static void registrarNombres(Juego juego, Scanner input, int nPlayers) {
		for(int i = 0; i < nPlayers; i++) {
        	System.out.println("Digite nombre jugador #"+(i+1));
        	String nombre = input.nextLine();
        	juego.crearJugador(nombre);
        }
	}
	
	public static void main(String[] args) {
		mensajeBienvenida();
		 
		Juego juego = new Juego();
		crearJugadores(juego);

		System.out.println("\n##Progreso aleatorio de jugadores##");
		while(Podio.isCarreraActiva()) {
			juego.avanzarCarros();
		}
	}
}
