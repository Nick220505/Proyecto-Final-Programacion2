package co.edu.unbosque.model;

import java.util.List;

import javax.faces.bean.ManagedBean;

import co.edu.unbosque.dao.EmisoraDAO;
import co.edu.unbosque.dao.ModoTransmisionDAO;
import co.edu.unbosque.dao.TipoMusicaDAO;

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
	
	public void crear() {
		
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
			e.printStackTrace();
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
			e.printStackTrace();
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
