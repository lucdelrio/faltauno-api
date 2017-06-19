package ar.api.faltauno.servicios;

import java.util.List;

import ar.api.faltauno.modelo.Jugador;
import ar.api.faltauno.modelo.Partido;

public interface ServicioJugador {

	List<Jugador> getJugadores();

	void guardarJugador(Jugador jugador);
	
    boolean jugadorExiste(Jugador jugador);

    Jugador findById(int jugadorId);

}
