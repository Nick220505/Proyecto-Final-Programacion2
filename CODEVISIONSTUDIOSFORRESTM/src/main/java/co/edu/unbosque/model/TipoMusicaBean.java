package co.edu.unbosque.model;

import javax.faces.bean.ManagedBean;

import co.edu.unbosque.dao.TipoMusicaDAO;

@ManagedBean
public class TipoMusicaBean {

	private TipoMusicaDAO gestorTipoMusica;
	private String tipo;

	public TipoMusicaBean() {
		gestorTipoMusica = new TipoMusicaDAO();
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
