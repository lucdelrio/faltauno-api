package ar.api.faltauno.controladores;


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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import ar.api.faltauno.modelo.Partido;
import ar.api.faltauno.modelo.Usuario;
import ar.api.faltauno.servicios.MatchService;

@RestController
public class MatchController {
	
	@Autowired
    private MatchService matchService;
	
    @RequestMapping(value = "/match", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> postMatch(@RequestBody Partido match, UriComponentsBuilder ucBuilder) {
 
        if (matchService.isMatchExist(match)) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        matchService.saveMatch(match);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/match/{id}").buildAndExpand(match.getMatchId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    

}
