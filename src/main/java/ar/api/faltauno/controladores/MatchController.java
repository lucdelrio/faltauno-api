package ar.api.faltauno.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import ar.api.faltauno.modelo.Match;
import ar.api.faltauno.servicios.MatchService;

@RestController
public class MatchController {
	
	@Autowired
    MatchService matchService;
	
    //Create Match
    @RequestMapping(value = "/match", method = RequestMethod.POST)
    public ResponseEntity<Void> createMatch(@RequestBody Match match, UriComponentsBuilder ucBuilder) {
 
        if (matchService.isMatchExist(match)) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        matchService.saveMatch(match);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/match/{id}").buildAndExpand(match.getMatchId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
	

}
