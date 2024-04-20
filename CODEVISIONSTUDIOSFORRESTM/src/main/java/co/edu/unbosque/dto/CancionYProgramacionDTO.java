package co.edu.unbosque.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "canciones_y_programaciones")
public class CancionYProgramacionDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "id_cancion")
	private int idCancion;

	@Column(name = "id_programacion")
	private int idProgramacion;

	public CancionYProgramacionDTO() {}

	public CancionYProgramacionDTO(int idCancion, int idProgramacion) {
		this.idCancion = idCancion;
		this.idProgramacion = idProgramacion;
	}

	@Override
	public String toString() {
		return "CancionYProgramacionDTO [id=" + id + ", idCancion=" + idCancion + ", idProgramacion=" + idProgramacion
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
