package co.edu.unbosque.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emisoras")
public class EmisoraDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "id_modo_transmision")
	private int idModoTransmision;

	@Column(name = "id_tipo_musica")
	private int idTipoMusica;

	public EmisoraDTO() {}

	public EmisoraDTO(String nombre, int idModoTransmision, int idTipoMusica) {
		this.nombre = nombre;
		this.idModoTransmision = idModoTransmision;
		this.idTipoMusica = idTipoMusica;
	}

	@Override
	public String toString() {
		return "EmisoraDTO [id=" + id + ", nombre=" + nombre + ", idModoTransmision=" + idModoTransmision
				+ ", idTipoMusica=" + idTipoMusica + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
