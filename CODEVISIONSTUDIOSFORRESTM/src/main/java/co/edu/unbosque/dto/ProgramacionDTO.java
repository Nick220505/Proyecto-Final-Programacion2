package co.edu.unbosque.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "programaciones")
public class ProgramacionDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "fecha")
	private Date fecha;

	public ProgramacionDTO() {}

	public ProgramacionDTO(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "ProgramacionDTO [id=" + id + ", fecha=" + fecha + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
