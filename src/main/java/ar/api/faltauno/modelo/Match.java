package ar.api.faltauno.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Match {
	
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer matchId;
	
	
    private String ownerName;
    private String countOfPlayers;
    private String time;
    private String date;
    private String gender;
    private String address;
    private String city;
	
    public void setMatchId(Integer matchId){
        this.matchId = matchId;
    }

    public int getMatchId(){
        return this.matchId;
    }

    public void setOwnerName(String owner){
        this.ownerName = owner;
    }

    public String getOwnerName(){
        return ownerName;
    }

    public void setCountOfPlayers(String count){
        this.countOfPlayers = count;
    }

    public String getCountOfPlayers() {
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
