package ar.api.faltauno.modelo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Partido {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "match_id")
	private Long matchId;
	
	@Column(name = "owner_name")
    private String ownerName;
    
	@Column(name = "count_of_players")
    private Integer countOfPlayers;
    
	@Column(name = "time")
    private String time;
  
	@Column(name = "date")
    private String date;
  
	@Column(name = "gender")
    private String gender;

	@Column(name = "address")
	private String address;

	@Column(name = "city")
	private String city;
	
	@Column(name = "cupo")
	private String cupo;
	
	@Column(name = "nivel")
	private String nivel;
	
	@Column(name = "categoria")
	private String categoria;
	
    public void setMatchId(Long matchId){
        this.matchId = matchId;
    }

    public Long getMatchId(){
        return this.matchId;
    }

    public void setOwnerName(String owner){
        this.ownerName = owner;
    }

    public String getOwnerName(){
        return ownerName;
    }

    public void setCountOfPlayers(Integer count){
        this.countOfPlayers = count;
    }

    public Integer getCountOfPlayers() {
        return countOfPlayers;
    }

    public void setTime(String time){
        this.time = time;
    }

    public String getTime(){
        return time;
    }

    public void setDate(String date){
        this.date = date;
    }

    public String getDate(){
        return date;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getGender(){
        return gender;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return address;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getCity() {
        return city;
    }
    
    public void setCupo(String cupo){
        this.cupo = cupo;
    }

    public String getCupo() {
        return cupo;
    }
    
    public void setNivel(String nivel){
        this.nivel = nivel;
    }

    public String getNivel() {
        return nivel;
    }
    
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria	;
    }

}
