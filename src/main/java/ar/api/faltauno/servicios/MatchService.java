package ar.api.faltauno.servicios;

import java.util.List;

import ar.api.faltauno.modelo.Match;

public interface MatchService {

    Match findById(int matchId);
    
    //Match findByName(String name);
     
    void saveMatch(Match match);
     
    void updateMatch(Match match);
     
    void deleteMatchById(int matchId);
 
    List<Match> findAllMatches();    
   
    public boolean isMatchExist(Match match);

}
