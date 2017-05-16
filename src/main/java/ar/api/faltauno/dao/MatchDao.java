package ar.api.faltauno.dao;

import ar.api.faltauno.modelo.Partido;

public interface MatchDao {

	Partido crearPartido(Partido match);

	void delete(int matchId);

	Partido findById(int matchId);

}
