package ar.api.faltauno.servicios;

import java.util.List;

import ar.api.faltauno.modelo.Partido;

public interface ServicioPartido {

    Partido findById(int partidoId);
    
    //Match findByName(String name);
     
    void saveMatch(Partido partido);
        
    void deleteMatchById(int partidoId);
 
    List<Partido> getPartidos();    
   
    public boolean isMatchExist(Partido partido);

	void updatePartido(Partido partido);

}
