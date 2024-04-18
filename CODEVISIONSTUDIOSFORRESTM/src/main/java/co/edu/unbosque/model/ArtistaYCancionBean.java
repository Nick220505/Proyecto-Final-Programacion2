package co.edu.unbosque.model;

import javax.faces.bean.ManagedBean;

import co.edu.unbosque.dao.ArtistaYCancionDAO;

@ManagedBean
public class ArtistaYCancionBean {

	private ArtistaYCancionDAO gestorArtistasYCanciones;
	private int idArtista;
	private int idCancion;

	public ArtistaYCancionBean() {
		gestorArtistasYCanciones = new ArtistaYCancionDAO();
	}

	public int getIdArtista() {
		return idArtista;
	}

	public void setIdArtista(int idArtista) {
		this.idArtista = idArtista;
	}

	public int getIdCancion() {
		return idCancion;
	}

	public void setIdCancion(int idCancion) {
		this.idCancion = idCancion;
	}
}
