package co.edu.unbosque.model;

import javax.faces.bean.ManagedBean;

import co.edu.unbosque.dao.ArtistaDAO;

@ManagedBean
public class ArtistaBean {

	private ArtistaDAO gestorArtistas;
	private String nombre;

	public ArtistaBean() {
		gestorArtistas = new ArtistaDAO();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
