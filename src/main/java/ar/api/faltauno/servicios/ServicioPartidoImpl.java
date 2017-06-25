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
	public Partido findById(int partidoId) {		
		return partidoDao.findById(partidoId);
	}

	@Override
	public void saveMatch(Partido partido) {
		this.partidoDao.crearPartido(partido);
	}

	@Override
	public void updatePartido(Partido partido) {
		this.partidoDao.updatePartido(partido);

	}

	@Override
	public void deleteMatchById(int partidoId) {
       this.partidoDao.delete(partidoId);	
	}

	@Override
    public List<Partido> getPartidos() {
		return this.partidoDao.getPartidos();
    }

	@Override
	public boolean isMatchExist(Partido partido) {
        return false;
	}

	@Override
	public List<Partido> getPartidosMasculino() {
		return this.partidoDao.getPartidosMasculino();
	}

	@Override
	public List<Partido> getPartidosFemenino() {
		return this.partidoDao.getPartidosFemenino();
	}

	@Override
	public List<Partido> getPartidosMixto() {
		return this.partidoDao.getPartidosMixto();
	}
 
}
