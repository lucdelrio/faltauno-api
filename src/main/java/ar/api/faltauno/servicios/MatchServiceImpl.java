package ar.api.faltauno.servicios;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.api.faltauno.dao.MatchDao;
import ar.api.faltauno.modelo.Partido;

@Service("matchService")
@Transactional
public class MatchServiceImpl implements MatchService{
	
    private static final AtomicInteger counter = new AtomicInteger();
   
    @Inject
	private MatchDao matchDao;
      
	@Override
	public Partido findById(int matchId) {		
		return matchDao.findById(matchId);
	}

	@Override
	public void saveMatch(Partido match) {
		this.matchDao.crearPartido(match);
	}

	@Override
	public void updateMatch(Partido match) {
	}

	@Override
	public void deleteMatchById(int matchId) {
       this.matchDao.delete(matchId);	
	}

	@Override
    public List<Partido> findAllMatches() {
        return null;
    }

	@Override
	public boolean isMatchExist(Partido match) {
        return false;
	}
 
}