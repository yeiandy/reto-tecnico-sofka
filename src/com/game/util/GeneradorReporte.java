package com.game.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.game.entity.Carro;

public class GeneradorReporte {
	
	private static FileWriter csvWriter;
	private static List<List<String>> registros;
	
	static {
		try {
			inicializar();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static List<List<String>> getRegistros() {
		return registros;
	}

	private static void inicializar() throws IOException {
		registros = new ArrayList<List<String>>();
		csvWriter = new FileWriter("./reporteJuego.csv", true);
	}
	
	public static void procesarInformacion(List<Carro> corredores) throws IOException {
		for(int i = 0; i < corredores.size(); i++)  {
			Carro carro = corredores.get(i);
			List<String> registro = Arrays.asList(new String[] { carro.getConductor().getNombre(), String.valueOf(i+1)});	
			registros.add(registro);
		}
		guardarInformacion();
	}

	private static void guardarInformacion() throws IOException {
		for (List<String> datos : registros) {
				csvWriter.append(String.join(",", datos)+"\n");
		}
		csvWriter.flush();
		csvWriter.close();
	}
}
