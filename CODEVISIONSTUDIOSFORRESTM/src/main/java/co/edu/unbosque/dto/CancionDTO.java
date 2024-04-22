package co.edu.unbosque.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "canciones")
public class CancionDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "url")
	private String url;

	@Column(name = "id_emisora")
	private int idEmisora;

	@Column(name = "id_genero_musical")
	private int idGeneroMusical;

	public CancionDTO() {}

	public CancionDTO(String nombre, String url, int idEmisora, int idGeneroMusical) {
		this.nombre = nombre;
		this.url = url;
		this.idEmisora = idEmisora;
		this.idGeneroMusical = idGeneroMusical;
	}

	@Override
	public String toString() {
		return "CancionDTO [id=" + id + ", nombre=" + nombre + ", url=" + url + ", idEmisora=" + idEmisora
				+ ", idGeneroMusical=" + idGeneroMusical + "]";
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getIdEmisora() {
		return idEmisora;
	}

	public void setIdEmisora(int idEmisora) {
		this.idEmisora = idEmisora;
	}

	public int getIdGeneroMusical() {
		return idGeneroMusical;
	}

	public void setIdGeneroMusical(int idGeneroMusical) {
		this.idGeneroMusical = idGeneroMusical;
	}

}
