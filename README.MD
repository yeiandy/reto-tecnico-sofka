# JUEGO DE CARRERAS - RETO TÉCNICO
- El juego define una pista única de 2KM. 
- Se asume que cada Carro tiene asociado un carril, por tanto solo se utiliza la entidad Carro.
- Cada Carro posee un Conductor, al cual se le asocia el nombre del jugador ingresado por Consola.
- El sistema automáticamente genera avance de cada carro utilizando un algoritmo aleatorio.
- Al finalizar la llegada a la meta (distancia 2KM), se asigna podio y se registra nombre y posición alcanzada. 
- La información relacionada con nombre y posición alcanzada se guarda en el archivo "ReporteJuego.CSV"

### Entidades definidas
- com.game.entity.Carro
- com.game.entity.Conductor
- com.game.entity.Pista
- com.game.entity.Podio

### Clase principal main
com.game.main.Juego

### Clase utilitaria para generar archivos
com.game.util.GeneradorReporte

