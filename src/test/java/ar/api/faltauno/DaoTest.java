package ar.api.faltauno;


import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ar.api.faltauno.dao.MatchDao;
import ar.api.faltauno.dao.MatchDaoImpl;
import ar.api.faltauno.modelo.Partido;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-applicationContext.xml" })
@Transactional @Rollback(true)
public class DaoTest {

	@Inject
	private MatchDao matchDao;

	
	@Test
	public void obtenerListaDePartidosDeberiaDevolverTresPartidos(){
		List<Partido> listaDePartidos = this.matchDao.obtenerPartidos();
		int valorEsperado = 1;
		
		Assert.assertEquals(valorEsperado, listaDePartidos.size());
	}
	
	@Before
	public void crearPartido(){
		Partido partido1 = new Partido();
		partido1.setAddress("Caseros");
		partido1.setCity("San Martin");
		partido1.setCountOfPlayers(5);
		partido1.setDate("14/11/17");
		partido1.setGender("Masculino");
		partido1.setOwnerName("Roberto");
		partido1.setTime("14:22");
		
		this.matchDao.crearPartido(partido1);
	}
	

}
