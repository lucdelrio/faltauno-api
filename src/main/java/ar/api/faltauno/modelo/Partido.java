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
	@Column(name = "id_partido")
	private Long id_partido;
	
	@Column(name = "nombre_organizador")
    private String nombreOrganizador;
    
	@Column(name = "tamanio_de_cancha")
    private Integer tamanioDeCancha;
    
	@Column(name = "hora")
    private String hora;
  
	@Column(name = "fecha")
    private String fecha;
  
	@Column(name = "genero")
    private String genero;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "ciudad")
	private String ciudad;
	
	@Column(name = "cupo")
	private String cupo;
	
	@Column(name = "nivel")
	private String nivel;
	
	@Column(name = "categoria")
	private String categoria;

	@Column(name = "email")
	private String email;
	
    public void setIdPartido(Long id_partido){
        this.id_partido = id_partido;
    }

    public Long getIdPartido(){
        return this.id_partido;
    }

    public void setNombreOrganizador(String nombreOrganizador){
        this.nombreOrganizador = nombreOrganizador;
    }

    public String getNombreOrganizador(){
        return nombreOrganizador;
    }

    public void setTamanioDeCancha(Integer tamanioDeCancha){
        this.tamanioDeCancha = tamanioDeCancha;
    }

    public Integer getTamanioDeCancha() {
        return tamanioDeCancha;
    }

    public void setHora(String hora){
        this.hora = hora;
    }

    public String getHora(){
        return hora;
    }

    public void setFecha(String fecha){
        this.fecha = fecha;
    }

    public String getFecha(){
        return fecha;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }

    public String getGenero(){
        return genero;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

    public String getDireccion(){
        return direccion;
    }

    public void setCiudad(String ciudad){
        this.ciudad = ciudad;
    }

    public String getCiudad() {
        return ciudad;
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
        return categoria;
    }
    
    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

}
