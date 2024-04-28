package co.edu.unbosque.forrestmback.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Emisora {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nombre;

	@Enumerated(EnumType.STRING)
	private ModoDeTransmision modoDeTransmision;

	@Enumerated(EnumType.STRING)
	private TipoDeMusica tipoDeMusica;

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

	public ModoDeTransmision getModoDeTransmision() {
		return modoDeTransmision;
	}

	public void setModoDeTransmision(ModoDeTransmision modoDeTransmision) {
		this.modoDeTransmision = modoDeTransmision;
	}

	public TipoDeMusica getTipoDeMusica() {
		return tipoDeMusica;
	}

	public void setTipoDeMusica(TipoDeMusica tipoDeMusica) {
		this.tipoDeMusica = tipoDeMusica;
	}

}
