package co.edu.unbosque.forrestmfront.model;

import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "pistaMusicalBean")
public class CreacionPistaMusicalBean extends BeanBase {

	private String nombre;
	private String nombreDelArtista;
	private String generoMusical;
	private String url;

	public String enviar() {
		try {
			Map<String, Object> datosPistaMusical = new HashMap<>();
			datosPistaMusical.put("nombre", getNombre());
			datosPistaMusical.put("nombreDelArtista", getNombreDelArtista());
			datosPistaMusical.put("generoMusical", getGeneroMusical());
			datosPistaMusical.put("url", getUrl());
			super.postJSON(datosPistaMusical, "pistas/guardar");
			return "programacionDelDia.xhtml?faces-redirect=true";
		} catch (Exception e) {
			redirigirAPaginaError(e.getMessage());
			return null;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreDelArtista() {
		return nombreDelArtista;
	}

	public void setNombreDelArtista(String nombreDelArtista) {
		this.nombreDelArtista = nombreDelArtista;
	}

	public String getGeneroMusical() {
		return generoMusical;
	}

	public void setGeneroMusical(String generoMusical) {
		this.generoMusical = generoMusical;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
