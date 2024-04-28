package co.edu.unbosque.forrestmback.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PistaMusical {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nombre;

	private String nombreDelArtista;

	@Enumerated(EnumType.STRING)
	private GeneroMusical generoMusical;

	private String url;

	@Column(columnDefinition = "boolean default false")
	private boolean agregada;

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

	public String getNombreDelArtista() {
		return nombreDelArtista;
	}

	public void setNombreDelArtista(String nombreDelArtista) {
		this.nombreDelArtista = nombreDelArtista;
	}

	public GeneroMusical getGeneroMusical() {
		return generoMusical;
	}

	public void setGeneroMusical(GeneroMusical generoMusical) {
		this.generoMusical = generoMusical;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isAgregada() {
		return agregada;
	}

	public void setAgregada(boolean agregada) {
		this.agregada = agregada;
	}

}
