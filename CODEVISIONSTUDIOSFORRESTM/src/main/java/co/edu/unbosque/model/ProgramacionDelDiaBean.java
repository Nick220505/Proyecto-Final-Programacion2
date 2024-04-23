package co.edu.unbosque.model;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import co.edu.unbosque.dao.ArtistaDAO;
import co.edu.unbosque.dao.CancionDAO;
import co.edu.unbosque.dao.EmisoraDAO;
import co.edu.unbosque.dao.GeneroMusicalDAO;
import co.edu.unbosque.dto.CancionDTO;

@ManagedBean
public class ProgramacionDelDiaBean {
	
	private EmisoraDAO gestorEmisoras;
	private CancionDAO gestorCanciones;
	private GeneroMusicalDAO gestorDeGenerosMusicales;
	private ArtistaDAO gestorDeArtistas;

	private List<CancionDTO> canciones;
	
	private List<CancionDTO> cancionesAgregadas;
	
	public ProgramacionDelDiaBean() {
		gestorEmisoras = new EmisoraDAO();
		gestorCanciones = new CancionDAO();
		gestorDeGenerosMusicales = new GeneroMusicalDAO();
		gestorDeArtistas = new ArtistaDAO();
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

	public List<CancionDTO> getCanciones() {
		try {
			setCanciones(gestorCanciones.listar());
		} catch (Exception e) {
			redirigirAPaginaError(e.getMessage());
		}
		return canciones;
	}

	public void setCanciones(List<CancionDTO> canciones) {
		this.canciones = canciones;
	}

	public List<CancionDTO> getCancionesAgregadas() {
		return cancionesAgregadas;
	}

	public void setCancionesAgregadas(List<CancionDTO> cancionesAgregadas) {
		this.cancionesAgregadas = cancionesAgregadas;
	}
	
}
