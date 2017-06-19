package ar.api.faltauno.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.api.faltauno.dao.JugadorDao;
import ar.api.faltauno.dao.PartidoDao;
import ar.api.faltauno.modelo.Jugador;
import ar.api.faltauno.modelo.Partido;

//Service indica a Spring que es un beans y que forma parte del modelo. 
//Es equivalente a @Component, pero viene bien especificar a que parte pertenece.
@Service("servicioJugador")
//Transaccional indica que la transacci�n o se completa entera o se hace rollback
@Transactional
public class ServicioJugadorImpl implements ServicioJugador{

    @Inject
	private JugadorDao jugadorDao;
      
	@Override
	public Jugador findById(int jugadorId) {		
		return jugadorDao.findById(jugadorId);
	}

	@Override
	public void guardarJugador(Jugador jugador) {
		this.jugadorDao.crearJugador(jugador);
	}

	@Override
    public List<Jugador> getJugadores() {
		return this.jugadorDao.getJugadores();
    }

	@Override
	public boolean jugadorExiste(Jugador jugador) {
        return false;
	}
	
}
