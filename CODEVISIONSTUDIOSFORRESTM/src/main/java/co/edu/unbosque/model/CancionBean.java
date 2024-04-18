package co.edu.unbosque.model;

import javax.faces.bean.ManagedBean;

import co.edu.unbosque.dao.CancionDAO;

@ManagedBean
public class CancionBean {

	private CancionDAO gestorCanciones;
	private String nombre;
	private String nombreArchivo;
	private int idEmisora;

	public CancionBean() {
		gestorCanciones = new CancionDAO();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public int getIdEmisora() {
		return idEmisora;
	}

	public void setIdEmisora(int idEmisora) {
		this.idEmisora = idEmisora;
	}
}
