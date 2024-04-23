package co.edu.unbosque.model;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import co.edu.unbosque.dao.ArtistaDAO;
import co.edu.unbosque.dao.ArtistaYCancionDAO;
import co.edu.unbosque.dao.CancionDAO;
import co.edu.unbosque.dao.EmisoraDAO;
import co.edu.unbosque.dao.GeneroMusicalDAO;
import co.edu.unbosque.dto.ArtistaDTO;
import co.edu.unbosque.dto.ArtistaYCancionDTO;
import co.edu.unbosque.dto.CancionDTO;

@ManagedBean
public class CreacionCancionBean {

	private GeneroMusicalDAO gestorGenerosMusicales;
	private CancionDAO gestorCanciones;
	private EmisoraDAO gestorEmisoras;
	private ArtistaDAO gestorArtistas;
	private ArtistaYCancionDAO gestorCancionesYArtistas;

	private String nombre;
	private String artista;

	private List<String> generosMusicales;
	private String generoMusical;

	private String url;

	public CreacionCancionBean() {
		gestorGenerosMusicales = new GeneroMusicalDAO();
		gestorCanciones = new CancionDAO();
		gestorEmisoras = new EmisoraDAO();
		gestorArtistas = new ArtistaDAO();
		gestorCancionesYArtistas = new ArtistaYCancionDAO();
	}

	public String enviar() {

		try {
			gestorArtistas.agregar(new ArtistaDTO(getArtista()));
			int idEmisoraActual, idGeneroMusical = 0;
			try {
				System.out.println("Pasando por emisora");
				idEmisoraActual = gestorEmisoras.obtenerIdEmisoraActual();
			} catch (Exception e) {
				return null;
			}
			idGeneroMusical = gestorGenerosMusicales.obtenerGeneroMusical(getGeneroMusical());
			gestorCanciones.agregar(new CancionDTO(getNombre(), getUrl(), idEmisoraActual, idGeneroMusical));				
			int idArtista = gestorArtistas.obtenerIdArtista(getArtista());
			int idCancion = gestorCanciones.obtenerIdCancion(getUrl());
			gestorCancionesYArtistas.agregar(new ArtistaYCancionDTO(idArtista, idCancion));
		} catch (Exception e) {
			redirigirAPaginaError(e.getMessage());
		}

		return "paginaInicio.xhtml";
	}

	public void reiniciarEntradas() {
		setNombre("");
		setArtista("");
		setUrl("");
	}

	public void redirigirAPaginaError(String mensaje) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		externalContext.getSessionMap().put("mensajeError", mensaje);
		try {
			externalContext.redirect("error.xhtml");
		} catch (Exception e2) {
			e2.printStackTrace();
		}
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

	public List<String> getGenerosMusicales() {
		try {
			setGenerosMusicales(gestorGenerosMusicales.listarGenerosMusicales());
		} catch (Exception e) {
			redirigirAPaginaError(e.getMessage());
		}
		return generosMusicales;
	}

	public void setGenerosMusicales(List<String> generosMusicales) {
		this.generosMusicales = generosMusicales;
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
