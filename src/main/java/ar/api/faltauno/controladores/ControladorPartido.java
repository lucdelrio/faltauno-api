package ar.api.faltauno.controladores;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import ar.api.faltauno.modelo.Jugador;
import ar.api.faltauno.modelo.Partido;
import ar.api.faltauno.modelo.Usuario;
import ar.api.faltauno.servicios.ServicioPartido;

@RestController
public class ControladorPartido {
	
	//Autowired indica a Spring que sessionFactory tiene que inyectarlo
	@Autowired
    private ServicioPartido servicioPartido;
	
	//RequestMapping forma parte de las anotaciones de springMVC que su funcionamiento se basa en recoger las peticiones
	//que se hacen a la url relativa, en este caso la ra�z, e indica a Spring que esta es la clase que maneja la vista.
    @RequestMapping(value = "/matches", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> postMatches(@RequestBody Partido partido, UriComponentsBuilder ucBuilder) {
 
        if (servicioPartido.isMatchExist(partido)) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
		servicioPartido.saveMatch(partido);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/match/{id}").buildAndExpand(partido.getIdPartido()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/matches", method = RequestMethod.GET)
    public List<Partido> getPartidos() {
        List<Partido> partidos = servicioPartido.getPartidos();
        return partidos;
 
    }
    
    
    @RequestMapping(value = "/matches/update", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> updatePartido(@RequestBody Partido partido, UriComponentsBuilder ucBuilder) {

        servicioPartido.updatePartido(partido);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/matches/{id}").buildAndExpand(partido.getIdPartido()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.OK);
    }

}
