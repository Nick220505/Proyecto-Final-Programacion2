package co.edu.unbosque.dto;

public class CancionDTO {
	private String nombre;
	private String nombreArchivo;
	private int idEmisora;
	
	public CancionDTO(String nombre, String nombreArchivo, int idEmisora) {
		this.nombre = nombre;
		this.nombreArchivo = nombreArchivo;
		this.idEmisora = idEmisora;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public int getIdEmisora() {
		return idEmisora;
	}

	public void setIdEmisora(int idEmisora) {
		this.idEmisora = idEmisora;
	}
	
}
