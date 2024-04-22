package co.edu.unbosque.model;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class CreacionCancionBean {
	
	private String nombre;
	private String artista;
	private String url;
	
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
