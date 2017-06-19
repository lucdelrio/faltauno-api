package ar.api.faltauno.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.api.faltauno.modelo.Partido;

//Repository indica a Spring que es un beans y que forma parte del modelo. 
//Es equivalente a @Component, pero viene bien especificar a que parte pertenece.
@Repository("partidoDao")
public class PartidoDaoImpl implements PartidoDao {

	@Inject
    private SessionFactory sessionFactory;
	
	@Override
	public Partido crearPartido(Partido match) {
		final Session session = sessionFactory.getCurrentSession();
		
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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Partido> getPartidos() {
		final Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("FROM Partido p ORDER BY p.cupo ASC");
		   
		return  query.list();
	}

}
