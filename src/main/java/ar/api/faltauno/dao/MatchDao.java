package ar.api.faltauno.dao;

import java.util.List;

import ar.api.faltauno.modelo.Partido;

public interface MatchDao {

	Partido crearPartido(Partido match);

	void delete(int matchId);

	Partido findById(int matchId);

	List<Partido> obtenerPartidos();

}
