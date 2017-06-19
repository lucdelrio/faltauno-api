package ar.api.faltauno.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Jugador {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_jugador")
	private Long id_jugador;
	
	@Column(name = "id_partido")
    private Long id_partido;
    
	@Column(name = "nombre_jugador")
    private String nombreJugador;
    	
    public void setIdPartido(Long id_partido){
        this.id_partido = id_partido;
    }

    public Long getIdPartido(){
        return this.id_partido;
    }

    public void setNombreJugador(String nombreJugador){
        this.nombreJugador = nombreJugador;
    }

    public String getNombreJugador(){
        return nombreJugador;
    }

    public void setIdJugador(Long id_jugador){
        this.id_jugador = id_jugador;
    }

    public Long getIdJugador(){
        return this.id_jugador;
    }

}

