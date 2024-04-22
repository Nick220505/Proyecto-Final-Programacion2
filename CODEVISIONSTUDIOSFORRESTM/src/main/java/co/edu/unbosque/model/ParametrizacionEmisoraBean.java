package co.edu.unbosque.model;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import co.edu.unbosque.dao.EmisoraDAO;
import co.edu.unbosque.dao.ModoTransmisionDAO;
import co.edu.unbosque.dao.TipoMusicaDAO;
import co.edu.unbosque.dto.EmisoraDTO;

@ManagedBean
public class ParametrizacionEmisoraBean {

	private EmisoraDAO gestorEmisoras;
	private ModoTransmisionDAO gestorModosDeTransmision;
	private TipoMusicaDAO gestorTiposDeMusica;

	private String nombreEmisora;

	private List<String> modosDeTransmision;
	private String modoDeTransmision;

	private List<String> tiposDeMusica;
	private String tipoDeMusica;

	public ParametrizacionEmisoraBean() {
		gestorEmisoras = new EmisoraDAO();
		gestorModosDeTransmision = new ModoTransmisionDAO();
		gestorTiposDeMusica = new TipoMusicaDAO();
	}

	public String crear() {
		try {
			int idModoDeTransmision = gestorModosDeTransmision.obtenerIdModoDeTransmision(getModoDeTransmision());
			int idTipoDeMusica = gestorTiposDeMusica.obtenerIdTipoDeMusica(getTipoDeMusica());
			if (!gestorEmisoras.existeEmisora()) {
				gestorEmisoras.agregar(new EmisoraDTO(getNombreEmisora(), idModoDeTransmision, idTipoDeMusica));
			} else {
				int idEmisoraActual = gestorEmisoras.obtenerIdEmisoraActual();
				EmisoraDTO nuevaEmisora = new EmisoraDTO(getNombreEmisora(), idModoDeTransmision, idTipoDeMusica);
				nuevaEmisora.setId(idEmisoraActual);
				gestorEmisoras.actualizar(idEmisoraActual, nuevaEmisora);
			}
			return "paginaInicio.xhtml";
		} catch (Exception e) {
			redirigirAPaginaError(e.getMessage());
			return "error.xhtml";
		}
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

	public String getNombreEmisora() {
		return nombreEmisora;
	}

	public void setNombreEmisora(String nombreEmisora) {
		this.nombreEmisora = nombreEmisora;
	}

	public List<String> getModosDeTransmision() {
		try {
			setModosDeTransmision(gestorModosDeTransmision.listarModosDeTransmision());
		} catch (Exception e) {
			redirigirAPaginaError(e.getMessage());
		}
		return modosDeTransmision;
	}

	public void setModosDeTransmision(List<String> modosDeTransmision) {
		this.modosDeTransmision = modosDeTransmision;
	}

	public String getModoDeTransmision() {
		return modoDeTransmision;
	}

	public void setModoDeTransmision(String modoDeTransmision) {
		this.modoDeTransmision = modoDeTransmision;
	}

	public List<String> getTiposDeMusica() {
		try {
			setTiposDeMusica(gestorTiposDeMusica.listarTiposDeMusica());
		} catch (Exception e) {
			redirigirAPaginaError(e.getMessage());
		}
		return tiposDeMusica;
	}

	public void setTiposDeMusica(List<String> tiposDeMusica) {
		this.tiposDeMusica = tiposDeMusica;
	}

	public String getTipoDeMusica() {
		return tipoDeMusica;
	}

	public void setTipoDeMusica(String tipoDeMusica) {
		this.tipoDeMusica = tipoDeMusica;
	}

}
