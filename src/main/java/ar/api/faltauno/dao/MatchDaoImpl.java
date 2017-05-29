package ar.api.faltauno.dao;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ar.api.faltauno.modelo.Partido;

@Repository("matchDao")
public class MatchDaoImpl implements MatchDao {

	@Inject
    private SessionFactory sessionFactory;
	
	@Override
	public Partido crearPartido(Partido match) {
		final Session session = sessionFactory.openSession();
		
		session.save(match);
		
		return match;
	}

	@Override
	public void delete(int matchId) {
		this.sessionFactory.getCurrentSession().delete(this.findById(matchId));;
	}

	@Override
	public Partido findById(int matchId) {
		return this.sessionFactory.getCurrentSession().get(Partido.class, matchId);
	}

}
