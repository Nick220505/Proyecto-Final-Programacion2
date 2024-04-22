package co.edu.unbosque.model;

import javax.faces.bean.ManagedBean;

import co.edu.unbosque.dao.ArtistaDAO;
import co.edu.unbosque.dao.ArtistaYCancionDAO;
import co.edu.unbosque.dao.CancionDAO;

@ManagedBean
public class CreacionCancionBean {
	
	private CancionDAO gestorCanciones;
	private ArtistaDAO gestorArtistas;
	private ArtistaYCancionDAO gestorCancionesYArtistas;
	
	private String nombre;
	private String artista;
	private String url;
	
	public CreacionCancionBean() {
		gestorCanciones = new CancionDAO();
		gestorArtistas = new ArtistaDAO();
		gestorCancionesYArtistas = new ArtistaYCancionDAO();
	}
	
	public String enviar() {
		
		
		
		return "paginaInicio.xhtml";
	}
	
	public void reiniciarEntradas() {
		setNombre("");
		setArtista("");
		setUrl("");
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getArtista() {
		return artista;
	}
	
	public void setArtista(String artista) {
		this.artista = artista;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
}
