package ar.api.faltauno.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ar.api.faltauno.modelo.Jugador;
import ar.api.faltauno.modelo.Partido;

//Repository indica a Spring que es un beans y que forma parte del modelo. 
//Es equivalente a @Component, pero viene bien especificar a que parte pertenece.
@Repository("jugadorDao")
public class JugadorDaoImpl implements JugadorDao{
	
	@Inject
    private SessionFactory sessionFactory;
	
	public Jugador crearJugador(Jugador jugador) {
		
		final Session session = sessionFactory.getCurrentSession();
		
		session.save(jugador);
		
		return jugador;
	}
	
	@Override
	public List<Jugador> getJugadores() {
		final Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("FROM Jugador");
		   
		return  query.list();
	}

	@Override
	public List<Jugador> getJugadoresPorIdPartido(Long idPartido) {
		final Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("FROM Jugador j WHERE j.id_partido == idPartido");
		   
		return  query.list();
	}

	@Override
	public void delete(int jugadorId) {
		this.sessionFactory.getCurrentSession().delete(this.findById(jugadorId));;
	}

	@Override
	public Jugador findById(int jugadorId) {
		return this.sessionFactory.getCurrentSession().get(Jugador.class, jugadorId);
	}

}
