package ar.api.faltauno.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.api.faltauno.dao.PartidoDao;
import ar.api.faltauno.modelo.Partido;

//Service indica a Spring que es un beans y que forma parte del modelo. 
//Es equivalente a @Component, pero viene bien especificar a que parte pertenece.
@Service("matchService")
//Transaccional indica que la transacci�n o se completa entera o se hace rollback
@Transactional
public class ServicioPartidoImpl implements ServicioPartido{
	  
    @Inject
	private PartidoDao partidoDao;
      
	@Override
	public Partido findById(int matchId) {		
		return partidoDao.findById(matchId);
	}

	@Override
	public void saveMatch(Partido match) {
		this.partidoDao.crearPartido(match);
	}

	@Override
	public void updateMatch(Partido match) {
	}

	@Override
	public void deleteMatchById(int matchId) {
       this.partidoDao.delete(matchId);	
	}

	@Override
    public List<Partido> getPartidos() {
		return this.partidoDao.getPartidos();
    }

	@Override
	public boolean isMatchExist(Partido match) {
        return false;
	}
 
}
