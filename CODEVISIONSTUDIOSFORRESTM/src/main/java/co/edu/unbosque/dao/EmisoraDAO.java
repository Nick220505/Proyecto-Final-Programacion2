package co.edu.unbosque.dao;

import co.edu.unbosque.dto.EmisoraDTO;

public class EmisoraDAO extends Gestion<EmisoraDTO> {

	public EmisoraDAO() {
		super(EmisoraDTO.class);
	}
	
	public boolean existeEmisora(String nombre) throws Exception {
		return listar().stream().anyMatch(e -> e.getNombre().equals(nombre));
	}

}
