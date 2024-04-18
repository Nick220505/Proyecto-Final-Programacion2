package co.edu.unbosque.model;

import java.util.Date;

import javax.faces.bean.ManagedBean;

import co.edu.unbosque.dao.ProgramacionDAO;

@ManagedBean
public class ProgramacionBean {

	private ProgramacionDAO gestorProgramaciones;
	private Date fecha;

	public ProgramacionBean() {
		gestorProgramaciones = new ProgramacionDAO();
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
