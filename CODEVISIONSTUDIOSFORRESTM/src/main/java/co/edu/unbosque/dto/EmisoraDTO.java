package co.edu.unbosque.dto;

public class EmisoraDTO {
	private String nombre;
	private int idModoTransmision;
	private int idTipoMusica;
	
	public EmisoraDTO(String nombre, int idModoTransmision, int idTipoMusica) {
		this.nombre = nombre;
		this.idModoTransmision = idModoTransmision;
		this.idTipoMusica = idTipoMusica;
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
