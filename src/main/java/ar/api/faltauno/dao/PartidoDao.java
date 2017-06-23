package ar.api.faltauno.dao;

import java.util.List;

import ar.api.faltauno.modelo.Partido;

public interface PartidoDao {

	Partido crearPartido(Partido partido);

	void delete(int partido);

	Partido findById(int partidoId);

	List<Partido> getPartidos();
	
	Partido updatePartido(Partido partido);


}
