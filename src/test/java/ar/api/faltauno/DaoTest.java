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

import ar.api.faltauno.dao.PartidoDao;
import ar.api.faltauno.dao.PartidoDaoImpl;
import ar.api.faltauno.modelo.Partido;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-applicationContext.xml" })
@Transactional @Rollback(true)
public class DaoTest {

	@Inject
	private PartidoDao matchDao;

	
	@Test
	public void obtenerListaDePartidosDeberiaDevolverTresPartidos(){
		List<Partido> listaDePartidos = this.matchDao.getPartidos();
		int valorEsperado = 1;
		
		Assert.assertEquals(valorEsperado, listaDePartidos.size());
	}
	
	@Before
	public void crearPartido(){
		Partido partido1 = new Partido();
		partido1.setDireccion("Caseros");
		partido1.setCiudad("San Martin");
		partido1.setTamanioDeCancha(5);
		partido1.setFecha("14/11/17");
		partido1.setGenero("Masculino");
		partido1.setNombreOrganizador("Roberto");
		partido1.setHora("14:22");
		
		this.matchDao.crearPartido(partido1);
	}
	

}
