package co.edu.unbosque.dto;

public class CancionYProgramacionDTO {
	private int idCancion;
	private int idProgramacion;

	public CancionYProgramacionDTO(int idCancion, int idProgramacion) {
		this.idCancion = idCancion;
		this.idProgramacion = idProgramacion;
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
