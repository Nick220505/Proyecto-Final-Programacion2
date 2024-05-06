package co.edu.unbosque.forrestmback.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Emisora {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nombre;

	private String modoDeTransmision;

	private String tipoDeMusica;

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

	public String getModoDeTransmision() {
		return modoDeTransmision;
	}

	public void setModoDeTransmision(String modoDeTransmision) {
		this.modoDeTransmision = modoDeTransmision;
	}

	public String getTipoDeMusica() {
		return tipoDeMusica;
	}

	public void setTipoDeMusica(String tipoDeMusica) {
		this.tipoDeMusica = tipoDeMusica;
	}

}
