package co.edu.unbosque.dao;

import co.edu.unbosque.dto.ArtistaDTO;

public class ArtistaDAO extends Gestion<ArtistaDTO> {

	public ArtistaDAO() {
		super(ArtistaDTO.class);
	}

	public boolean existeArtista(String nombre) throws Exception {
		return listar().stream().anyMatch(a -> a.getNombre().equalsIgnoreCase(nombre));
	}
	
	public int obtenerIdArtista(String nombre) throws Exception {
		return listar().stream().filter(a -> a.getNombre().equals(nombre)).findFirst().orElseThrow().getId();
	}

}
