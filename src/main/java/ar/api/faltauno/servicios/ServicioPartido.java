package ar.api.faltauno.servicios;

import java.util.List;

import ar.api.faltauno.modelo.Partido;

public interface ServicioPartido {

    Partido findById(int matchId);
    
    //Match findByName(String name);
     
    void saveMatch(Partido match);
     
    void updateMatch(Partido match);
     
    void deleteMatchById(int matchId);
 
    List<Partido> findAllMatches();    
   
    public boolean isMatchExist(Partido match);

}
