package co.edu.unbosque.model;

import javax.faces.bean.ManagedBean;

import co.edu.unbosque.dao.CancionYProgramacionDAO;

@ManagedBean
public class CancionYProgramacionBean {

	private CancionYProgramacionDAO gestorCancionesYProgramaciones;
	private int idCancion;
	private int idProgramacion;

	public CancionYProgramacionBean() {
		gestorCancionesYProgramaciones = new CancionYProgramacionDAO();
	}

	public int getIdCancion() {
		return idCancion;
	}

	public void setIdCancion(int idCancion) {
		this.idCancion = idCancion;
	}

	public int getIdProgramacion() {
		return idProgramacion;
	}

	public void setIdProgramacion(int idProgramacion) {
		this.idProgramacion = idProgramacion;
	}
}
