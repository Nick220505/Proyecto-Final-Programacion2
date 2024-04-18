package co.edu.unbosque.dto;

import java.sql.Date;

public class ProgramacionDTO {

	private Date fecha;

	public ProgramacionDTO(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
