package ar.api.faltauno.modelo;

import java.sql.Date;

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
}
