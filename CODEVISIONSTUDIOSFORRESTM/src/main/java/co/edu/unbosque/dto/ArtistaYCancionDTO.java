package co.edu.unbosque.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "artistas_y_canciones")
public class ArtistaYCancionDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "id_artista")
	private int idArtista;

	@Column(name = "id_cancion")
	private int idCancion;

	public ArtistaYCancionDTO() {}

	public ArtistaYCancionDTO(int idArtista, int idCancion) {
		this.idArtista = idArtista;
		this.idCancion = idCancion;
	}

	@Override
	public String toString() {
		return "ArtistaYCancionDTO [id=" + id + ", idArtista=" + idArtista + ", idCancion=" + idCancion + "]";
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
