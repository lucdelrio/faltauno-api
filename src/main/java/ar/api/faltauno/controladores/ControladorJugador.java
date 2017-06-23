package ar.api.faltauno.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import ar.api.faltauno.modelo.Jugador;
import ar.api.faltauno.modelo.Partido;
import ar.api.faltauno.servicios.ServicioJugador;
import ar.api.faltauno.servicios.ServicioPartido;

@RestController
public class ControladorJugador {

	//Autowired indica a Spring que sessionFactory tiene que inyectarlo
	@Autowired
    private ServicioJugador servicioJugador;
	
	//RequestMapping forma parte de las anotaciones de springMVC que su funcionamiento se basa en recoger las peticiones
	//que se hacen a la url relativa, en este caso la ra�z, e indica a Spring que esta es la clase que maneja la vista.
    @RequestMapping(value = "/players", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> postJugadores(@RequestBody Jugador jugador, UriComponentsBuilder ucBuilder) {
 
        if (servicioJugador.jugadorExiste(jugador)) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
		servicioJugador.guardarJugador(jugador);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/player/{id}").buildAndExpand(jugador.getIdPartido()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/players", method = RequestMethod.GET)
    public List<Jugador> getJugadores() {
        List<Jugador> partidos = servicioJugador.getJugadores();
        return partidos;
 
    }

}
