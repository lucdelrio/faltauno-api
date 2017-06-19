package ar.api.faltauno.dao;

import java.util.List;

import ar.api.faltauno.modelo.Jugador;
import ar.api.faltauno.modelo.Partido;

public interface JugadorDao {
	
	Jugador crearJugador(Jugador jugador);

	List<Jugador> getJugadoresPorIdPartido(Long id);

	List<Jugador> getJugadores();

	Jugador findById(int jugadorId);

	void delete(int jugadorId);
}
