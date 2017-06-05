package ar.api.faltauno.controladores;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import ar.api.faltauno.modelo.Partido;
import ar.api.faltauno.modelo.Usuario;
import ar.api.faltauno.servicios.MatchService;

@RestController
public class MatchController {
	
	//Autowired indica a Spring que sessionFactory tiene que inyectarlo
	@Autowired
    private MatchService matchService;
	
	//RequestMapping forma parte de las anotaciones de springMVC que su funcionamiento se basa en recoger las peticiones
	//que se hacen a la url relativa, en este caso la raíz, e indica a Spring que esta es la clase que maneja la vista.
    @RequestMapping(value = "/matches", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> postMatches(@RequestBody Partido match, UriComponentsBuilder ucBuilder) {
 
        if (matchService.isMatchExist(match)) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
		matchService.saveMatch(match);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/match/{id}").buildAndExpand(match.getMatchId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/matches", method = RequestMethod.GET)
    public List<Partido> getMatches() {
        return matchService.findAllMatches();
 
    }

}
