package co.edu.unbosque.model;

import javax.faces.bean.ManagedBean;

import co.edu.unbosque.dao.EmisoraDAO;

@ManagedBean
public class EmisoraBean {
	
	private EmisoraDAO gestorEmisoras;
	private String nombre;
	private int idModoTransmision;
	private int idTipoMusica;
	
	public EmisoraBean() {
		gestorEmisoras = new EmisoraDAO();
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getIdModoTransmision() {
		return idModoTransmision;
	}
	
	public void setIdModoTransmision(int idModoTransmision) {
		this.idModoTransmision = idModoTransmision;
	}
	
	public int getIdTipoMusica() {
		return idTipoMusica;
	}
	
	public void setIdTipoMusica(int idTipoMusica) {
		this.idTipoMusica = idTipoMusica;
	}
}
